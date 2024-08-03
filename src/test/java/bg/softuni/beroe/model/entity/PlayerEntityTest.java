package bg.softuni.beroe.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerEntityTest {

    @Test
    void testPlayerEntity() {
        // Arrange
        PlayerEntity playerEntity = new PlayerEntity();

        String expectedPlayerName = "John Doe";
        String expectedPosition = "Forward";

        // Act
        playerEntity.setPlayerName(expectedPlayerName);
        playerEntity.setPosition(expectedPosition);

        // Assert
        assertEquals(expectedPlayerName, playerEntity.getPlayerName(), "Player name should match");
        assertEquals(expectedPosition, playerEntity.getPosition(), "Position should match");
    }
}
