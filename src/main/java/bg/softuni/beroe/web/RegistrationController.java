package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.dto.UserRegistrationDTO;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import bg.softuni.beroe.service.UserService;
import bg.softuni.beroe.service.exception.CustomException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class RegistrationController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private final UserService userService;

  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

//  @ModelAttribute("allRoles")
//  public List<UserRoleEnum> allRoles() {
//    return Arrays.asList(UserRoleEnum.values());
//  }

  @ModelAttribute("allRoles")
  public UserRoleEnum[] allRoles() {
    return UserRoleEnum.values();
  }

//  @ModelAttribute("registerDTO")
//  public UserRegistrationDTO registerDTO() {
//    return new UserRegistrationDTO();
//  }

  @GetMapping("/register")
  public String register(Model model) {
    if (!model.containsAttribute("registerDTO")) {
      model.addAttribute("registerDTO", new UserRegistrationDTO());
    }
    System.out.println();

    logger.debug("GET /users/register - registerDTO: {}", model.getAttribute("registerDTO"));
    logger.debug("GET /users/register - BindingResult: {}", model.getAttribute("org.springframework.validation.BindingResult.registerDTO"));

    return "auth-register";
  }

  @PostMapping("/register")
  public String register(@Valid UserRegistrationDTO registerDTO,
                         BindingResult bindingResult,
                         RedirectAttributes rAtt) {

    if(bindingResult.hasErrors()){
      rAtt.addFlashAttribute("registerDTO", registerDTO);
      rAtt.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
      return "redirect:/users/register";
    }

    System.out.println("Register Debug: " + registerDTO);
    userService.registerUser(registerDTO);
    System.out.println();
    return "redirect:/";
  }


  @GetMapping("/beroe")
  public String test() throws InsufficientResourcesException {

//    throw new NullPointerException("SAMO BEROE");

    throw new CustomException("SAMO BEROE");
  }

}
