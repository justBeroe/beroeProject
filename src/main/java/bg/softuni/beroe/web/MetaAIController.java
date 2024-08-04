package bg.softuni.beroe.web;


import bg.softuni.beroe.model.dto.AIDTO;
import bg.softuni.beroe.model.dto.ChoicesDTO;
import bg.softuni.beroe.model.dto.ResponseAIDTO;

import bg.softuni.beroe.service.AIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MetaAIController {

    private final AIService aiService;

    public MetaAIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/api/getAI")
    public ResponseEntity<ChoicesDTO> getAIresponse(
//            @RequestParam("from") String from,
//            @RequestParam("to") String to,
//            @RequestParam("amount") BigDecimal amount
    ) {
       // Weather1DTO weather1DTO = weatherService.fetchTemp1();
      //  ChoicesDTO choicesDTO = aiService.fetchAIResponse();
        ChoicesDTO choicesDTO1 = aiService.fetchChoices();

        System.out.println(choicesDTO1);

        return ResponseEntity.ok(choicesDTO1);
    }
}
