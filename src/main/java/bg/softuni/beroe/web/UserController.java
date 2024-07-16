package bg.softuni.beroe.web;

import bg.softuni.beroe.config.SchedulerConfig;
import bg.softuni.beroe.model.dto.CronDTO;
import bg.softuni.beroe.model.dto.SearchFanItemsByIdDTO;
import bg.softuni.beroe.service.UserService;
import bg.softuni.beroe.service.WeatherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final WeatherService weatherService;

    private final SchedulerConfig schedulerConfig;

    public UserController(UserService userService, WeatherService weatherService, SchedulerConfig schedulerConfig) {
        this.userService = userService;
        this.weatherService = weatherService;
        this.schedulerConfig = schedulerConfig;
    }

    @GetMapping("/users/profile")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("profile");

        modelAndView.addObject("profileData", userService.getProfileData());
        modelAndView.addObject("profileDataCityOnly", weatherService.fetchCity().getCity());


        return modelAndView;
    }

    @GetMapping("/users/config")
    public ModelAndView configurationPage() {
        ModelAndView modelAndView = new ModelAndView("update-cron");



        //modelAndView.addObject("profileData", userService.getProfileData());
        //modelAndView.addObject("profileDataCityOnly", weatherService.fetchCity().getCity());


        return modelAndView;
    }

//

    @PostMapping("/users/config")
    public ModelAndView cronConfigurePage(@ModelAttribute CronDTO cronDTO) {
        ModelAndView modelAndView = new ModelAndView("update-cron");

        String cron = cronDTO.getCron();
        System.out.println("New Cron Expression: " + cron);

        // Update the cron expression
        schedulerConfig.setCronExpression(cron);

        // Add feedback to the model
        modelAndView.addObject("message", "Cron expression updated to: " + cron);
        return modelAndView;
    }
}
