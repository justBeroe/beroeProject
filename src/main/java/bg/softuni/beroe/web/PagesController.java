package bg.softuni.beroe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PagesController {

    @GetMapping("/about")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("about");

//        modelAndView.addObject("profileData", userService.getProfileData());
//        modelAndView.addObject("profileDataCityOnly", weatherService.fetchCity().getCity());


        return modelAndView;
    }
}
