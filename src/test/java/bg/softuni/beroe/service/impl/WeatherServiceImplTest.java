package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.dto.LocationDTO;
import bg.softuni.beroe.model.dto.Weather1DTO;
import bg.softuni.beroe.model.dto.WeatherDTO;
import bg.softuni.beroe.repository.ExRateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WeatherServiceImplTest {

    @Autowired
    private WeatherServiceImpl weatherService;

    @MockBean
    private ExRateRepository exRateRepository;

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        // You can initialize or configure anything needed before each test
    }

    @Test
    void fetchCity() {
        LocationDTO result = weatherService.fetchCity();
        assertNotNull(result);
        assertTrue(result.getCity() != null && !result.getCity().isEmpty());
    }

    @Test
    void fetchTemp() {
        WeatherDTO result = weatherService.fetchTemp();
        assertNotNull(result);
        // Add more specific assertions depending on what the WeatherDTO contains
    }

    @Test
    void fetchTemp1() {
        Weather1DTO result = weatherService.fetchTemp1();
        assertNotNull(result);
        // Add more specific assertions depending on what the Weather1DTO contains
    }
}
