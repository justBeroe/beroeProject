package bg.softuni.beroe.web;

import bg.softuni.beroe.service.WeatherService;
import bg.softuni.beroe.service.exception.CustomException;
import bg.softuni.beroe.service.exception.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

  private WeatherService weatherService;
  @ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
  @ExceptionHandler(NoSuchElementException.class)
  public ModelAndView handleObjectNotFound(NoSuchElementException onfe) {
    ModelAndView modelAndView = new ModelAndView("object-not-found");
    modelAndView.addObject("objectId", onfe.getId());

    return modelAndView;
  }

//  @ResponseStatus(code = HttpStatus.NOT_FOUND)
//  //@ExceptionHandler()
//  public ModelAndView handleObjectNotFound1( Model model) {
//    ModelAndView modelAndView = new ModelAndView("404");
//  //  modelAndView.addObject("objectId", onfe.getId());
//    model.addAttribute("profileDataCityOnly", weatherService.fetchCity().getCity());
//
//    return modelAndView;
//  }

  @ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
  @ExceptionHandler(CustomException.class)
  public ModelAndView handleObjectNotFound(CustomException onfe) {
    ModelAndView modelAndView = new ModelAndView("custom-object-not-found");
    //modelAndView.addObject("objectId", onfe.getId());

    return modelAndView;
  }

}
