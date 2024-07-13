package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.dto.OfferDetailsDTO;
import bg.softuni.beroe.model.dto.OfferSummaryDTO;
import bg.softuni.beroe.model.entity.OfferEntity;
import bg.softuni.beroe.repository.OfferRepository;
import bg.softuni.beroe.service.ExRateService;
import bg.softuni.beroe.service.OfferService;
import bg.softuni.beroe.service.exception.NoSuchElementException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OfferServiceImpl implements OfferService {

  private Logger LOGGER = LoggerFactory.getLogger(OfferServiceImpl.class);
  private final RestClient offerRestClient;
  private final OfferRepository offerRepository;
  private final ExRateService exRateService;

  public OfferServiceImpl(
      @Qualifier("offersRestClient") RestClient offerRestClient,
      OfferRepository offerRepository,

      ExRateService exRateService) {
    this.offerRestClient = offerRestClient;
    this.offerRepository = offerRepository;
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
    return offerRepository.save(map(addOfferDTO)).getId();
  }

  @Override
  public void deleteOffer(long offerId) {
    offerRepository.deleteById(offerId);
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

    return this.offerRepository
            .findById(id)
            .map(this::toOfferDetails)
            // offerEntity -> toOfferDetails(offerEntity
           // .orElseThrow();
          .orElseThrow(() -> new NoSuchElementException("No offers found with id: " + id,  id));

    //Error will be passed to @ExceptionHandler(NoSuchElementException.class) in OfferController
    // and trigger a view
  }

  private OfferDetailsDTO toOfferDetails(OfferEntity offerEntity) {
    // todo use mapping library
    return new OfferDetailsDTO(offerEntity.getId(),
            offerEntity.getDescription(),
            offerEntity.getMileage(),
            offerEntity.getPrice(),
            offerEntity.getEngine(),
            offerEntity.getImageUrl(),
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
    return offerRepository
            .findAll()
            .stream()
            .map(OfferServiceImpl::toOfferSummary)
            .toList();
  }

  private static OfferSummaryDTO toOfferSummary(OfferEntity offerEntity) {
    // todo use mapping library
    return new OfferSummaryDTO(offerEntity.getId(),
            offerEntity.getDescription(),
            offerEntity.getMileage(),
            offerEntity.getEngine(),
            offerEntity.getImageUrl());
  }



  private static OfferEntity map(AddOfferDTO addOfferDTO) {
    // todo - use mapped (e.g. ModelMapper)
    return new OfferEntity()
            .setDescription(addOfferDTO.description())
            .setEngine(addOfferDTO.engineType())
            .setMileage(addOfferDTO.mileage())
            .setPrice(addOfferDTO.price())
            .setImageUrl(addOfferDTO.imageUrl());
  }
}




