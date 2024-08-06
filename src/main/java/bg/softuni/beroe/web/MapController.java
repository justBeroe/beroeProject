package bg.softuni.beroe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

    @GetMapping("/map")
    public ModelAndView beroeLocation() {
        ModelAndView modelAndView = new ModelAndView("map");
        //modelAndView.addObject("profileData", userService.getProfileData());
        //modelAndView.addObject("profileDataCityOnly", weatherService.fetchCity().getCity());
        return modelAndView;
    }

    @GetMapping("/top101")
    public ModelAndView topSongs() {
        ModelAndView modelAndView = new ModelAndView("top10");
        //modelAndView.addObject("profileData", userService.getProfileData());
        //modelAndView.addObject("profileDataCityOnly", weatherService.fetchCity().getCity());
        return modelAndView;
    }
}
