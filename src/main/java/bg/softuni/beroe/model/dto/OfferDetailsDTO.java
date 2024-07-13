package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.enums.EngineTypeEnum;
import java.util.List;

public record OfferDetailsDTO(Long id,
                              String description,
                              Integer mileage,
                              Integer price,
                              EngineTypeEnum engineType,
                              String imageUrl,
                              List<String> allCurrencies) {

}
