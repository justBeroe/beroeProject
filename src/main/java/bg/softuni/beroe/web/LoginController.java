package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class LoginController {


  /// TEST 2 git

//  @GetMapping("/login")
//  public String login() {
//    return "auth-login";
//  }


  @GetMapping("/login")
  public ModelAndView viewLogin() {
    ModelAndView modelAndView = new ModelAndView("auth-login");

    modelAndView.addObject("loginData", new UserLoginDTO(null, null));

    return modelAndView;
  }

  @GetMapping("/login-error")
  public ModelAndView viewLoginError() {
    ModelAndView modelAndView = new ModelAndView("auth-login");

    modelAndView.addObject("showErrorMessage", true);
    modelAndView.addObject("loginData", new UserLoginDTO(null, null));

    return modelAndView;
  }
}
