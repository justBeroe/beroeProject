package bg.softuni.beroe.service.exception;

import bg.softuni.beroe.service.exception.CustomException;
import bg.softuni.beroe.service.exception.NoSuchElementException;
import bg.softuni.beroe.web.GlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void testHandleNoSuchElementException() {
        // Arrange
        NoSuchElementException exception = new NoSuchElementException("Test message", "123");

        // Act
        ModelAndView result = globalExceptionHandler.handleObjectNotFound(exception);

        // Assert
        assertEquals("object-not-found", result.getViewName());
        assertEquals("123", result.getModel().get("objectId"));
        assertNull(result.getStatus()); // Expecting status to be null
    }

    @Test
    void testHandleCustomException() {
        // Arrange
        CustomException exception = new CustomException("Test message");

        // Act
        ModelAndView result = globalExceptionHandler.handleObjectNotFound(exception);

        // Assert
        assertEquals("custom-object-not-found", result.getViewName());
        // Expecting status to be null
        assertNull(result.getStatus());
    }
}
