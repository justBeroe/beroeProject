package bg.softuni.beroe.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INSUFFICIENT_STORAGE, reason = "SAMO BEROE reason")
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}

