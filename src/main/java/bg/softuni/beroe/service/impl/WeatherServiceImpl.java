package bg.softuni.beroe.service.impl;


import bg.softuni.beroe.model.dto.LocationDTO;
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

    public WeatherServiceImpl(ExRateRepository exRateRepository, @Qualifier("weatherRestClient") RestClient restClient) {
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



}
