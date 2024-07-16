package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.enums.FanSizeEnum;

public record OfferSummaryDTO(Long id,
                              String description,
                              String item,
                              FanSizeEnum fanSize,
                              String imageUrl,
                              String username,
                              int price) {

}
