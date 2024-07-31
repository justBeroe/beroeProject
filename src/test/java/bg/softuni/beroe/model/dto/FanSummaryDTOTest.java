package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.dto.FanSummaryDTO;
import bg.softuni.beroe.model.enums.FanSizeEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FanSummaryDTOTest {

    @Test
    public void testFanSummaryDTO() {
        Long id = 1L;
        String description = "Description";
        String item = "Item";
        FanSizeEnum fanSize = FanSizeEnum.M;
        String imageUrl = "http://image.url";
        String username = "user123";
        int price = 100;

        FanSummaryDTO fanSummaryDTO = new FanSummaryDTO(id, description, item, fanSize, imageUrl, username, price);

        assertEquals(id, fanSummaryDTO.id());
        assertEquals(description, fanSummaryDTO.description());
        assertEquals(item, fanSummaryDTO.item());
        assertEquals(fanSize, fanSummaryDTO.fanSize());
        assertEquals(imageUrl, fanSummaryDTO.imageUrl());
        assertEquals(username, fanSummaryDTO.username());
        assertEquals(price, fanSummaryDTO.price());
    }
}
