package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.UserRegistrationDTO;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import bg.softuni.beroe.service.UserService;
import bg.softuni.beroe.service.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class RegistrationController {

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

  @ModelAttribute("registerDTO")
  public UserRegistrationDTO registerDTO() {
    return new UserRegistrationDTO();
  }

  @GetMapping("/register")
  public String register() {
    return "auth-register";
  }

  @PostMapping("/register")
  public String register(UserRegistrationDTO registerDTO) {

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
