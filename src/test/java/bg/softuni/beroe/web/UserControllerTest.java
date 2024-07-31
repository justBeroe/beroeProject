package bg.softuni.beroe.web;

import bg.softuni.beroe.config.SchedulerConfig;
import bg.softuni.beroe.model.dto.CronDTO;
import bg.softuni.beroe.model.dto.SearchFanItemsByIdDTO;
import bg.softuni.beroe.service.UserService;
import bg.softuni.beroe.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private WeatherService weatherService;

    @Mock
    private SchedulerConfig schedulerConfig;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testProfile() {
//        // Given
//        String mockCity = "SampleCity";
//        Object mockProfileData = new Object(); // Replace with actual profile data type if known
//
//        when(userService.getProfileData()).thenReturn(mockProfileData);
//        when(weatherService.fetchCity()).thenReturn(new WeatherCity(mockCity)); // Replace WeatherCity with actual type if different
//
//        // When
//        ModelAndView modelAndView = userController.profile();
//
//        // Then
//        assertEquals("profile", modelAndView.getViewName());
//        assertEquals(mockProfileData, modelAndView.getModel().get("profileData"));
//        assertEquals(mockCity, modelAndView.getModel().get("profileDataCityOnly"));
//    }

    @Test
    void testConfigurationPage() {
        // When
        ModelAndView modelAndView = userController.configurationPage();

        // Then
        assertEquals("update-cron", modelAndView.getViewName());
        assertEquals(null, modelAndView.getModel().get("profileData")); // No data added in the method
    }

//    @Test
//    void testUsersConfigurationPage() {
//        // Given
//        Object mockAllUsers = new Object(); // Replace with actual user data type if known
//
//        when(userService.findAllUsers()).thenReturn(mockAllUsers);
//
//        // When
//        ModelAndView modelAndView = userController.usersConfigurationPage();
//
//        // Then
//        assertEquals("users-config", modelAndView.getViewName());
//        assertEquals(mockAllUsers, modelAndView.getModel().get("allUsers"));
//    }

    @Test
    void testDeleteUser() {
        // Given
        Long userId = 1L;

        // When
        String viewName = userController.deleteUser(userId);

        // Then
        verify(userService, times(1)).deleteUserById(userId);
        assertEquals("redirect:/users/confusers", viewName);
    }

    @Test
    void testCronConfigurePage() {
        // Given
        CronDTO cronDTO = new CronDTO();
        cronDTO.setCron("0 0 * * *"); // Example cron expression

        // When
        ModelAndView modelAndView = userController.cronConfigurePage(cronDTO);

        // Then
        verify(schedulerConfig, times(1)).setCronExpression("0 0 * * *");
        assertEquals("update-cron", modelAndView.getViewName());
        assertEquals("Cron expression updated to: 0 0 * * *", modelAndView.getModel().get("message"));
    }

    // Mock class for WeatherCity
    static class WeatherCity {
        private String city;

        public WeatherCity(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }
}
