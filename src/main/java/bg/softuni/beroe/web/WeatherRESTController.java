package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.ConversionResultDTO;
import bg.softuni.beroe.model.dto.LocationDTO;
import bg.softuni.beroe.service.ExRateService;
import bg.softuni.beroe.service.WeatherService;
import bg.softuni.beroe.service.impl.WeatherServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController()
public class WeatherRESTController {

    private final WeatherService weatherService;

    public WeatherRESTController(WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    @GetMapping("/api/getCity")
    public ResponseEntity<LocationDTO> getCity(
//            @RequestParam("from") String from,
//            @RequestParam("to") String to,
//            @RequestParam("amount") BigDecimal amount
    ) {
        LocationDTO locationDTO = weatherService.fetchCity();
        System.out.println(locationDTO);

        return ResponseEntity.ok(locationDTO);
    }

}
