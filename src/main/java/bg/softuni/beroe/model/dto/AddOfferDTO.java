package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.enums.FanSizeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.userdetails.User;


public record AddOfferDTO(
    //@NotEmpty
    @Size(message = "Description should be between 5 and 500 symbols.",
        min = 3,
        max = 500) String description,//not necessarily from message source

    @Size(message = "Item should be between 5 and 50 symbols.",
            min = 5,
            max = 50)
    String item,
    @NotNull @PositiveOrZero Integer price,
    User user,

    @NotNull
     FanSizeEnum fanSizeEnum,
    @NotNull
    String imageUrl

) {

  public static AddOfferDTO empty() {
    return new AddOfferDTO(null, null, null, null, null, null);
  }

}
