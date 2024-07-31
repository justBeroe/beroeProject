package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.dto.CronDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronDTOTest {

    @Test
    public void testGetAndSetCron() {
        CronDTO cronDTO = new CronDTO();
        String cronExpression = "0 0 * * *";
        cronDTO.setCron(cronExpression);

        assertEquals(cronExpression, cronDTO.getCron());
    }
}
