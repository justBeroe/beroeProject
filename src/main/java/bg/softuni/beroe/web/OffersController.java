package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.OfferSummaryDTO;
import bg.softuni.beroe.model.dto.SearchFanItemsByIdDTO;
import bg.softuni.beroe.service.FanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OffersController {

  private final FanService fanService;

  public OffersController(FanService fanService) {

      this.fanService = fanService;
  }

  @GetMapping("/all")
  public String getAllOffers(Model model) {

    List<OfferSummaryDTO> allOffersSummary = fanService.getAllOffersSummary();

    model.addAttribute("allOffers", fanService.getAllOffersSummary());

    return "offers";
  }


  @PostMapping("/all")
  public String getOffersById(
          @ModelAttribute SearchFanItemsByIdDTO searchFanItemsById, Model model) {


    Long id = searchFanItemsById.getId();


    if (id == null || id <= 0){
      model.addAttribute("allOffers", fanService.getAllOffersSummary());

    } else {
      List<OfferSummaryDTO> searchResults = fanService.searchOffersByID(id);
      System.out.println(searchResults);
      model.addAttribute("allOffers", searchResults);
    }



    return "offers";



   // model.addAttribute("searchOffersByID", fanService.searchOffersByID());

   // return "offers";
  }

}
