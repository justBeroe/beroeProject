package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.enums.FanSizeEnum;
import bg.softuni.beroe.service.FanService;
import bg.softuni.beroe.service.UserHelperService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

  private final FanService fanService;


  public OfferController(FanService fanService, UserHelperService userHelperService) {
    this.fanService = fanService;

  }

  @ModelAttribute("allEngineTypes")
  public FanSizeEnum[] allEngineTypes() {
    return FanSizeEnum.values();
  }

  @GetMapping("/add")
  public String newOffer(Model model) {

    if (!model.containsAttribute("addOfferDTO")) {
      model.addAttribute("addOfferDTO", AddOfferDTO.empty());
    }

    return "offer-add";
  }

  @PostMapping("add")
  public String createOffer(
     AddOfferDTO addOfferDTO,
     // @Valid AddOfferDTO addOfferDTO,
      BindingResult bindingResult,
      RedirectAttributes rAtt) {

    if(bindingResult.hasErrors()){
      rAtt.addFlashAttribute("addOfferDTO", addOfferDTO);
      rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
      return "redirect:/offers/add";
    }

    System.out.println("AddOfferDTO" + addOfferDTO);
    fanService.createOffer(addOfferDTO);

    //offerService.createOffer1(addOfferDTO);

    return "redirect:/offers/all";
  }

  @GetMapping("/{id}")
  public String offerDetails(@PathVariable("id") Long id,
      Model model) {

    model.addAttribute("offerDetails", fanService.getOfferDetails(id));

    return "details";
  }

//  @ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
//  @ExceptionHandler(NoSuchElementException.class)
//  public ModelAndView handleObjectNotFound(NoSuchElementException onfe) {
//    ModelAndView modelAndView = new ModelAndView("offer-not-found");
//    modelAndView.addObject("offerId", onfe.getId());
//   // Error is coming from OfferServiceImpl line 80 and id is passed on service above line 71
//
//    return modelAndView;
//  }

  @DeleteMapping("/{id}")
  public String deleteOffer(@PathVariable("id") Long id) {

    fanService.deleteOffer(id);

    return "redirect:/offers/all";
  }
}
