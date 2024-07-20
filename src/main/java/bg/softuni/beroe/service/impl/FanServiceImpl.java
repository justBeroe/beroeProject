package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.dto.FanDetailsDTO;
import bg.softuni.beroe.model.dto.FanSummaryDTO;
import bg.softuni.beroe.model.entity.FanEntity;
import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.repository.FanRepository;
import bg.softuni.beroe.service.ExRateService;
import bg.softuni.beroe.service.FanService;
import bg.softuni.beroe.service.UserHelperService;
import bg.softuni.beroe.service.exception.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class FanServiceImpl implements FanService {

    private Logger LOGGER = LoggerFactory.getLogger(FanServiceImpl.class);
    private final RestClient offerRestClient;
    private final FanRepository fanRepository;
    private final ExRateService exRateService;
    private final UserHelperService userHelperService;

    public FanServiceImpl(
            @Qualifier("offersRestClient") RestClient offerRestClient,
            FanRepository fanRepository,

            ExRateService exRateService, UserHelperService userHelperService) {
        this.offerRestClient = offerRestClient;
        this.fanRepository = fanRepository;
        this.exRateService = exRateService;
        this.userHelperService = userHelperService;
    }

    @Override
    public void createOffer1(AddOfferDTO addOfferDTO) {
        LOGGER.info("Creating new offer...");

        // todo - fix baseUrl.
        offerRestClient
                .post()
                .uri("http://localhost:8082/offers")
                .body(addOfferDTO)
                .retrieve();
    }


    @Override
    public long createOffer(AddOfferDTO addOfferDTO) {

        FanEntity mappedWithCurrent = map(addOfferDTO);
        // Retrieve the currently authenticated user
        UserEntity currentUser = userHelperService.getUser();
        mappedWithCurrent.setUser(currentUser);
        return fanRepository.save(mappedWithCurrent).getId();
    }

    @Override
    public void deleteOffer(long offerId) {
        fanRepository.deleteById(offerId);
    }

    @Override
    public FanDetailsDTO getOfferDetails1(Long id) {

        return offerRestClient
                .get()
                .uri("http://localhost:8082/offers/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(FanDetailsDTO.class);
    }

    @Override
    public FanDetailsDTO getOfferDetails(Long id) {

        return this.fanRepository
                .findById(id)
                .map(this::toOfferDetails)
                // offerEntity -> toOfferDetails(offerEntity
                // .orElseThrow();
                .orElseThrow(() -> new NoSuchElementException("No offers found with id: " + id, id));

        //Error will be passed to @ExceptionHandler(NoSuchElementException.class) in OfferController
        // and trigger a view
    }

    private FanDetailsDTO toOfferDetails(FanEntity fanEntity) {
        // todo use mapping library
        return new FanDetailsDTO(fanEntity.getId(),
                fanEntity.getDescription(),
                fanEntity.getItem(),
                fanEntity.getPrice(),
                fanEntity.getFanSize(),
                fanEntity.getImageUrl(),
                exRateService.allSupportedCurrencies()
        );
    }


    ///


//  @Override
//  public List<OfferSummaryDTO> getAllOffersSummary() {
//    LOGGER.info("Get all offers...");
//
//    return offerRestClient
//        .get()
//        .uri("http://localhost:8081/offers")
//        .accept(MediaType.APPLICATION_JSON)
//        .retrieve()
//        .body(new ParameterizedTypeReference<>(){});
//  }

    @Override
    public List<FanSummaryDTO> getAllOffersSummary() {
        return fanRepository
                .findAll()
                .stream()
                .map(FanServiceImpl::toOfferSummary)
                //OR fanEntity -> toOfferSummary(fanEntity)
                .toList();
    }

    @Override
    public List<FanSummaryDTO> getOnlyUserOffersSummary() {

        String currentUsername = userHelperService.getUser().getUsername();

        List<FanSummaryDTO> list = fanRepository
                .findByUserUsername(currentUsername)
                .stream()
                .map(FanServiceImpl::toOfferSummary)
                .collect(Collectors.toList());

        return list;

//    List<OfferSummaryDTO> list = fanRepository
//            .findAll()
//            .stream()
//            .map(FanServiceImpl::toOfferSummary)
//             //OR fanEntity -> toOfferSummary(fanEntity)
//            .toList();
//    return list;
    }

    @Override
    public List<FanSummaryDTO> searchOffersByID(Long id) {
        return fanRepository
                .findById(id)
                .stream()
                .map(FanServiceImpl::toOfferSummary)
                .toList();
    }

    @Override
    public void updateFanPrice(Long id, Integer price) {
        fanRepository.updatePriceById(id, price);
    }

    @Override
    public void updateAllFanPrices() {
        List<FanEntity> fans = fanRepository.findAll();
        for (FanEntity fan : fans) {
            Integer newPrice = fan.getPrice() + 1; // Increase price by 1
            fan.setPrice(newPrice);
        }
        fanRepository.saveAll(fans); // Save all updated fan entities
    }

    private static FanSummaryDTO toOfferSummary(FanEntity fanEntity) {
        // todo use mapping library
        return new FanSummaryDTO(fanEntity.getId(),
                fanEntity.getDescription(),
                fanEntity.getItem(),
                fanEntity.getFanSize(),
                fanEntity.getImageUrl(),
                fanEntity.getUser().getUsername(),
                fanEntity.getPrice());
    }


    private static FanEntity map(AddOfferDTO addOfferDTO) {
        // todo - use mapped (e.g. ModelMapper)

        return new FanEntity()
                .setDescription(addOfferDTO.description())
                .setFanSize(addOfferDTO.fanSizeEnum())
                .setItem(addOfferDTO.item())
                .setPrice(addOfferDTO.price())

                .setImageUrl(addOfferDTO.imageUrl()

                );
    }
}




