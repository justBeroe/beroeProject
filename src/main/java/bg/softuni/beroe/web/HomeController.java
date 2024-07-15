package bg.softuni.beroe.web;

import bg.softuni.beroe.model.user.MobileleUserDetails;
import bg.softuni.beroe.service.UserService;
import bg.softuni.beroe.service.WeatherService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final WeatherService weatherService;

    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails,
                       Model model) {

        if (userDetails instanceof MobileleUserDetails mobileleUserDetails) {
            model.addAttribute("welcomeMessage", mobileleUserDetails.getFullName());
        } else {
            model.addAttribute("welcomeMessage", "Anonymous");
        }

        model.addAttribute("profileDataCityOnly", weatherService.fetchCity().getCity());
        model.addAttribute("TempOnly", weatherService.fetchTemp1().getCurrent().getTemp_c());

        return "index";
    }
}
