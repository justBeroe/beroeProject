package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.enums.FanSizeEnum;
import java.util.List;

public record FanDetailsDTO(Long id,
                            String description,
                            String item,
                            Integer price,
                            FanSizeEnum fanSize,
                            String imageUrl,
                            List<String> allCurrencies) {

}
