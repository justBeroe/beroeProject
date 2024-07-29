package bg.softuni.beroe.web;



import bg.softuni.beroe.config.WebConfig;
import bg.softuni.beroe.model.dto.LocationDTO;

import bg.softuni.beroe.model.dto.WeatherDTO;
import bg.softuni.beroe.service.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherRESTControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;



    @Autowired
    private ObjectMapper objectMapper; // For converting objects to JSON

    @BeforeEach
    void setUp() {

        // Sample data for LocationDTO
        LocationDTO mockLocationDTO = new LocationDTO();
        mockLocationDTO.setCity("Sofia");

        // Sample data for WeatherDTO
        WeatherDTO mockWeatherDTO = new WeatherDTO();
        WeatherDTO.CurrentWeather currentWeather = new WeatherDTO.CurrentWeather()
                .setLast_updated_epoch(1634044800L)
                .setLast_updated("2024-07-27 10:00")
                .setTemp_c(22.5)
                .setTemp_f(72.5)
                .setIs_day(1)
                .setCondition(new WeatherDTO.CurrentWeather.Condition()
                        .setText("Sunny")
                        .setIcon("//cdn.weatherapi.com/weather/64x64/day/113.png")
                        .setCode(1000)
                );
        mockWeatherDTO.setCurrent(currentWeather);

//        // Sample data for WeatherDTO
//        Weather1DTO mockWeatherDTO1 = new Weather1DTO();
//        Weather1DTO.CurrentWeather currentWeather1 = new Weather1DTO.CurrentWeather()
//                .setLast_updated_epoch(1634044800L)
//                .setLast_updated("2024-07-27 10:00")
//                .setTemp_c(22.5)
//                .setTemp_f(72.5)
//                .setIs_day(1)
//                .setCondition(new WeatherDTO.CurrentWeather.Condition()
//                        .setText("Sunny")
//                        .setIcon("//cdn.weatherapi.com/weather/64x64/day/113.png")
//                        .setCode(1000)
//                );
//        mockWeatherDTO1.setCurrent(currentWeather);

        // Mocking WeatherService methods
        given(weatherService.fetchCity()).willReturn(mockLocationDTO);
        //given(weatherService.fetchTemp()).willReturn(mockWeatherDTO1);
        given(weatherService.fetchTemp()).willReturn(mockWeatherDTO);
    }

    @Test
    void testGetCity() throws Exception {
        mockMvc.perform(get("/api/getCity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.city").value("Sofia"));
    }

    @Test
    void testGetTemp() throws Exception {
        mockMvc.perform(get("/api/getTemp")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.current.temp_c").value(22.5))
                .andExpect(jsonPath("$.current.temp_f").value(72.5))
                .andExpect(jsonPath("$.current.condition.text").value("Sunny"))
                .andExpect(jsonPath("$.current.condition.icon").value("//cdn.weatherapi.com/weather/64x64/day/113.png"))
                .andExpect(jsonPath("$.current.condition.code").value(1000));
    }

//    @Test
//    void testGetTemp1() throws Exception {
//        mockMvc.perform(get("/api/getTemp1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.temperature").value(20.0))
//                .andExpect(jsonPath("$.description").value("Sunny"));
//    }
}
