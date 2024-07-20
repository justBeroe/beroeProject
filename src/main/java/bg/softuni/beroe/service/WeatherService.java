package bg.softuni.beroe.service;


import bg.softuni.beroe.model.dto.LocationDTO;
import bg.softuni.beroe.model.dto.Weather1DTO;
import bg.softuni.beroe.model.dto.WeatherDTO;

public interface WeatherService {

    LocationDTO fetchCity();

    WeatherDTO fetchTemp();
    Weather1DTO fetchTemp1();
}
