package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.FanSummaryDTO;
import bg.softuni.beroe.model.dto.SearchFanItemsByIdDTO;
import bg.softuni.beroe.model.dto.UserProfileDto;
import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.entity.UserRoleEntity;
import bg.softuni.beroe.service.FanService;
import bg.softuni.beroe.service.UserHelperService;
import bg.softuni.beroe.service.UserService;
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
  private final UserHelperService userHelperService;
  private final UserService userService;

  public OffersController(FanService fanService, UserHelperService userHelperService, UserService userService) {

      this.fanService = fanService;
      this.userHelperService = userHelperService;
      this.userService = userService;
  }

  @GetMapping("/all")
  public String getAllOffers(Model model) {
    String currentUsername = userHelperService.getUser().getUsername();
    UserProfileDto profileData = userService.getProfileData();
    UserEntity user = userHelperService.getUser();
    UserRoleEntity first = user.getRoles().getLast();
    String userRole = first.getRole().toString();
  //  System.out.println(userRole);
    if (userRole.equals("ADMIN")) {

      List<FanSummaryDTO> allOffersSummary = fanService.getAllOffersSummary();
      model.addAttribute("allOffers", fanService.getAllOffersSummary());
    } else {
      List<FanSummaryDTO> onlyUserOffersSummary = fanService.getOnlyUserOffersSummary();
      model.addAttribute("allOffers", fanService.getOnlyUserOffersSummary());
    }

    return "offers";
  }


  @PostMapping("/all")
  public String getOffersById(
          @ModelAttribute SearchFanItemsByIdDTO searchFanItemsById, Model model) {


    Long id = searchFanItemsById.getId();


    if (id == null || id <= 0){
      model.addAttribute("allOffers", fanService.getAllOffersSummary());

    } else {
      List<FanSummaryDTO> searchResults = fanService.searchOffersByID(id);
      System.out.println(searchResults);
      model.addAttribute("allOffers", searchResults);
    }



    return "offers";



   // model.addAttribute("searchOffersByID", fanService.searchOffersByID());

   // return "offers";
  }

}
