package bg.softuni.beroe.service.impl;


import bg.softuni.beroe.model.dto.LocationDTO;
import bg.softuni.beroe.model.dto.Weather1DTO;
import bg.softuni.beroe.model.dto.WeatherDTO;
import bg.softuni.beroe.repository.ExRateRepository;
import bg.softuni.beroe.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);
  //  private final ExRateRepository exRateRepository;
    private final RestClient restClient;

    public WeatherServiceImpl(ExRateRepository exRateRepository,
                              @Qualifier("weatherRestClient") RestClient restClient) {
      //  this.exRateRepository = exRateRepository;
        this.restClient = restClient;
    }

    @Override
    public LocationDTO fetchCity() {
        return restClient
                .get()
                .uri("https://ipapi.co/json/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(LocationDTO.class);
    }

    @Override
    public WeatherDTO fetchTemp() {

        LocationDTO locationDTO = fetchCity();
        String city = locationDTO.getCity();

        String formatedURI = String.format("https://api.weatherapi.com/v1/forecast.json?q=%s&days=1&key=09e397eb3f2d4fee8e8230001241407", city);
        return restClient
                .get()
                .uri(formatedURI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(WeatherDTO.class);
    }

    @Override
    public Weather1DTO fetchTemp1() {
        LocationDTO locationDTO = fetchCity();
        String city = locationDTO.getCity();

        String formatedURI = String.format("https://api.weatherapi.com/v1/forecast.json?q=%s&days=1&key=09e397eb3f2d4fee8e8230001241407", city);
        return restClient
                .get()
                .uri(formatedURI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Weather1DTO.class);
    }



}
