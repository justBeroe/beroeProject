package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.enums.FanSizeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record AddOfferDTO(
    @NotEmpty(message = "{add.offer.description.not.empty}")
    @Size(message = "Description should be between 5 and 500 symbols.",
        min = 1,
        max = 500) String description,//not necessarily from message source
    String item,
    @NotNull @PositiveOrZero Integer price,

    @NotNull FanSizeEnum fanSizeEnum,
    @NotNull String imageUrl

) {

  public static AddOfferDTO empty() {
    return new AddOfferDTO(null, null, null, null, null);
  }

}
