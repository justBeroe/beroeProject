package bg.softuni.beroe.service;


import bg.softuni.beroe.model.dto.LocationDTO;

public interface WeatherService {

    LocationDTO fetchCity();
}
