package bg.softuni.beroe.web;

import bg.softuni.beroe.config.SchedulerConfig;
import bg.softuni.beroe.model.dto.CronDTO;
import bg.softuni.beroe.model.dto.SearchFanItemsByIdDTO;
import bg.softuni.beroe.service.UserService;
import bg.softuni.beroe.service.WeatherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/users/confusers")
    public ModelAndView usersConfigurationPage() {
        ModelAndView modelAndView = new ModelAndView("users-config");



        modelAndView.addObject("allUsers", userService.findAllUsers());
        //modelAndView.addObject("profileDataCityOnly", weatherService.fetchCity().getCity());


        return modelAndView;
    }

//    @DeleteMapping("/users/delete/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        System.out.println(id);
//        userService.deleteUserById(id);
//        return "redirect:/users/confusers";
//    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUserById(id);
        } catch (Exception e) {
            // Handle exceptions (e.g., log error or notify user)
            System.err.println("Error deleting user: " + e.getMessage());
        }
        return "redirect:/users/confusers"; // Redirect to a page showing the updated list of users
    }




    ////

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
