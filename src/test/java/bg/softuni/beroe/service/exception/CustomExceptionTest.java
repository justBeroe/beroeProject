package bg.softuni.beroe.service.exception;

import static org.junit.jupiter.api.Assertions.*;

import bg.softuni.beroe.service.exception.CustomException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CustomExceptionTest {

    @Test
    void testCustomException() {
        // Given
        String expectedMessage = "Custom message";
        CustomException exception = new CustomException(expectedMessage);

        // When
        HttpStatus actualStatus = getStatusFromException(exception);
        String actualMessage = exception.getMessage();

        // Then
        assertEquals(HttpStatus.INSUFFICIENT_STORAGE, actualStatus);
        assertEquals("SAMO BEROE reason", getReasonFromException(exception));
        assertEquals(expectedMessage, actualMessage);
    }

    private HttpStatus getStatusFromException(RuntimeException exception) {
        ResponseStatus statusAnnotation = exception.getClass().getAnnotation(ResponseStatus.class);
        return (statusAnnotation != null) ? statusAnnotation.code() : null;
    }

    private String getReasonFromException(RuntimeException exception) {
        ResponseStatus statusAnnotation = exception.getClass().getAnnotation(ResponseStatus.class);
        return (statusAnnotation != null) ? statusAnnotation.reason() : null;
    }
}
