package bg.softuni.beroe.service;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.dto.OfferDetailsDTO;
import bg.softuni.beroe.model.dto.OfferSummaryDTO;
import java.util.List;

public interface FanService {

  //void createOffer(AddOfferDTO addOfferDTO);
  long createOffer(AddOfferDTO addOfferDTO);

  void createOffer1(AddOfferDTO addOfferDTO);

  void deleteOffer(long offerId);

  OfferDetailsDTO getOfferDetails(Long id);
  OfferDetailsDTO getOfferDetails1(Long id);

  List<OfferSummaryDTO> getAllOffersSummary();

  List<OfferSummaryDTO> searchOffersByID(Long id);
}
