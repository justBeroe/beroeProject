package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.enums.EngineTypeEnum;

public record OfferSummaryDTO(Long id,
                              String description,
                              Integer mileage,
                              EngineTypeEnum engineType,
                              String imageUrl) {

}
