package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.LocationDTO;
import bg.softuni.beroe.model.dto.Weather1DTO;
import bg.softuni.beroe.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeControllerTests {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private HomeController homeController;

    @Mock
    private UserDetails userDetails;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //@Test
    void testHomeWithBeroeUserDetails() {
        // Arrange
        UserDetails mockUserDetails = mock(UserDetails.class);
        when(mockUserDetails.getUsername()).thenReturn("testuser");

        LocationDTO locationDTO = new LocationDTO().setCity("TestCity");

        Weather1DTO.Location weatherLocation = new Weather1DTO.Location();
        weatherLocation.setName("TestCity");

        Weather1DTO.Current weatherCurrent = new Weather1DTO.Current();
        weatherCurrent.setTemp_c(25.0);

        Weather1DTO weather1DTO = new Weather1DTO();
        weather1DTO.setLocation(weatherLocation);
        weather1DTO.setCurrent(weatherCurrent);

        when(weatherService.fetchCity()).thenReturn(locationDTO);
        when(weatherService.fetchTemp1()).thenReturn(weather1DTO);

        // Act
        String viewName = homeController.home(mockUserDetails, model);

        // Assert
        verify(model).addAttribute("welcomeMessage", "testuser");
        verify(model).addAttribute("profileDataCityOnly", "TestCity");
        verify(model).addAttribute("TempOnly", 25.0);
        assertEquals("index", viewName);
    }

    @Test
    void testHomeWithAnonymous() {
        // Arrange
        LocationDTO locationDTO = new LocationDTO().setCity("TestCity");

        Weather1DTO.Location weatherLocation = new Weather1DTO.Location();
        weatherLocation.setName("TestCity");

        Weather1DTO.Current weatherCurrent = new Weather1DTO.Current();
        weatherCurrent.setTemp_c(25.0);

        Weather1DTO weather1DTO = new Weather1DTO();
        weather1DTO.setLocation(weatherLocation);
        weather1DTO.setCurrent(weatherCurrent);

        when(weatherService.fetchCity()).thenReturn(locationDTO);
        when(weatherService.fetchTemp1()).thenReturn(weather1DTO);

        // Act
        String viewName = homeController.home(null, model); // Simulating an anonymous user

        // Assert
        verify(model).addAttribute("welcomeMessage", "Anonymous");
        verify(model).addAttribute("profileDataCityOnly", "TestCity");
        verify(model).addAttribute("TempOnly", 25.0);
        assertEquals("index", viewName);
    }
}
