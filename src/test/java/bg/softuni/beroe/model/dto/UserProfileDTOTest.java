package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.dto.UserProfileDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserProfileDTOTest {

    @Test
    public void testUserProfileDto() {
        UserProfileDto userProfileDto = new UserProfileDto();

        userProfileDto.setUsername("testUser");
        userProfileDto.setFirstName("Test");

        assertEquals("testUser", userProfileDto.getUsername());
        assertEquals("Test", userProfileDto.getFirstName());
    }
}
