package bg.softuni.beroe.service;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.dto.FanDetailsDTO;
import bg.softuni.beroe.model.dto.FanSummaryDTO;
import java.util.List;

public interface FanService {

  //void createOffer(AddOfferDTO addOfferDTO);
  long createOffer(AddOfferDTO addOfferDTO);

  void createOffer1(AddOfferDTO addOfferDTO);

  void deleteOffer(long offerId);

  FanDetailsDTO getOfferDetails(Long id);
  FanDetailsDTO getOfferDetails1(Long id);

  List<FanSummaryDTO> getAllOffersSummary();
  List<FanSummaryDTO> getOnlyUserOffersSummary();

  List<FanSummaryDTO> searchOffersByID(Long id);

  void updateFanPrice(Long id, Integer price);
}
