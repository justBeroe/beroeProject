package bg.softuni.beroe.web;



import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.enums.FanSizeEnum;
import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddOfferDTOTest {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    @Test
    void testValidAddOfferDTO() {
        AddOfferDTO dto = new AddOfferDTO(
                "Valid description",
                "item1",
                100,
                null, // Replace with actual User object if needed
                FanSizeEnum.S,
                "http://example.com/image.jpg"
        );

        var violations = validator.validate(dto);
        assertEquals(0, violations.size(), "No validation errors should occur");
    }

    @Test
    void testInvalidDescription() {
        AddOfferDTO dto = new AddOfferDTO(
                "", // Invalid description
                "item1",
                10, // Valid price
                null, // Replace with actual User object if needed
                FanSizeEnum.S, // Valid FanSizeEnum
                "http://example.com/image.jpg" // Valid imageUrl
        );

        var violations = validator.validate(dto);
        assertEquals(1, violations.size(), "There should be 1 validation error");

        // Check for the specific validation error message for the description
        var violation = violations.iterator().next();
        assertEquals("Description should be between 5 and 500 symbols.", violation.getMessage(), "Validation message for description should match");
    }


    @Test
    void testEmptyAddOfferDTO() {
        AddOfferDTO dto = AddOfferDTO.empty();

        assertEquals(null, dto.description());
        assertEquals(null, dto.item());
        assertEquals(null, dto.price());
        assertEquals(null, dto.user());
        assertEquals(null, dto.fanSizeEnum());
        assertEquals(null, dto.imageUrl());
    }
}
