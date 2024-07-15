package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.dto.OfferDetailsDTO;
import bg.softuni.beroe.model.dto.OfferSummaryDTO;
import bg.softuni.beroe.model.entity.FanEntity;
import bg.softuni.beroe.repository.FanRepository;
import bg.softuni.beroe.service.ExRateService;
import bg.softuni.beroe.service.FanService;
import bg.softuni.beroe.service.exception.NoSuchElementException;

import java.util.List;

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

  public FanServiceImpl(
      @Qualifier("offersRestClient") RestClient offerRestClient,
      FanRepository fanRepository,

      ExRateService exRateService) {
    this.offerRestClient = offerRestClient;
    this.fanRepository = fanRepository;
    this.exRateService = exRateService;
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
    return fanRepository.save(map(addOfferDTO)).getId();
  }

  @Override
  public void deleteOffer(long offerId) {
    fanRepository.deleteById(offerId);
  }

  @Override
  public OfferDetailsDTO getOfferDetails1(Long id) {

    return offerRestClient
        .get()
        .uri("http://localhost:8082/offers/{id}", id)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .body(OfferDetailsDTO.class);
  }

  @Override
  public OfferDetailsDTO getOfferDetails(Long id) {

    return this.fanRepository
            .findById(id)
            .map(this::toOfferDetails)
            // offerEntity -> toOfferDetails(offerEntity
           // .orElseThrow();
          .orElseThrow(() -> new NoSuchElementException("No offers found with id: " + id,  id));

    //Error will be passed to @ExceptionHandler(NoSuchElementException.class) in OfferController
    // and trigger a view
  }

  private OfferDetailsDTO toOfferDetails(FanEntity fanEntity) {
    // todo use mapping library
    return new OfferDetailsDTO(fanEntity.getId(),
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
  public List<OfferSummaryDTO> getAllOffersSummary() {
    return fanRepository
            .findAll()
            .stream()
            .map(FanServiceImpl::toOfferSummary)
            .toList();
  }

  @Override
  public List<OfferSummaryDTO> searchOffersByID(Long id) {
    return fanRepository
            .findById(id)
            .stream()
            .map(FanServiceImpl::toOfferSummary)
            .toList();
  }

  private static OfferSummaryDTO toOfferSummary(FanEntity fanEntity) {
    // todo use mapping library
    return new OfferSummaryDTO(fanEntity.getId(),
            fanEntity.getDescription(),
            fanEntity.getItem(),
            fanEntity.getFanSize(),
            fanEntity.getImageUrl(),
            fanEntity.getPrice());
  }



  private static FanEntity map(AddOfferDTO addOfferDTO) {
    // todo - use mapped (e.g. ModelMapper)
    return new FanEntity()
            .setDescription(addOfferDTO.description())
            .setFanSize(addOfferDTO.fanSizeEnum())
            .setItem(addOfferDTO.item())
            .setPrice(addOfferDTO.price())
            .setImageUrl(addOfferDTO.imageUrl());
  }
}




