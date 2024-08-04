package bg.softuni.beroe.service;

import bg.softuni.beroe.model.dto.AIDTO;
import bg.softuni.beroe.model.dto.ChoicesDTO;
import bg.softuni.beroe.model.dto.ResponseAIDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface AIService {

    ChoicesDTO fetchAIResponse();

    AIDTO setMessageContent(String message);
    ChoicesDTO fetchChoices(String message);
}
