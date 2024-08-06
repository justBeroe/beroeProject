package bg.softuni.beroe.web;

import bg.softuni.beroe.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/error")
    public String handleError(Model model) {
        // Add custom attributes to the model
        model.addAttribute("profileDataCityOnly", weatherService.fetchCity().getCity());
        model.addAttribute("TempOnly", weatherService.fetchTemp1().getCurrent().getTemp_c());
        return "404"; // Return the name of the custom 404 template
    }

//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
}
