package bg.softuni.beroe.web;


import bg.softuni.beroe.model.dto.AIDTO;
import bg.softuni.beroe.model.dto.ChoicesDTO;
import bg.softuni.beroe.model.dto.ResponseAIDTO;

import bg.softuni.beroe.service.AIService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MetaAIController {

    private final AIService aiService;

    public MetaAIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/api/getAI")
    public String showMessageForm() {
        return "ai-message";
    }

    @PostMapping("/api/getAI")
    public String getAIresponse(
            @RequestParam("content") String content, Model model
//            @RequestParam("from") String from,
//            @RequestParam("to") String to,
//            @RequestParam("amount") BigDecimal amount
    ) {
       // Weather1DTO weather1DTO = weatherService.fetchTemp1();
      //  ChoicesDTO choicesDTO = aiService.fetchAIResponse();

     //   AIDTO requestBody = aiService.setMessageContent(content);

        ChoicesDTO choicesDTO1 = aiService.fetchChoices(content);

        System.out.println(choicesDTO1);

        // Add response to the model
        model.addAttribute("content", content);
        model.addAttribute("response", choicesDTO1);


        return "ai-message";
    }



//    @PostMapping("/api/setMessageContent")
//    public String setMessageContent(@RequestParam("content") String content, Model model) {
//        // Call the setMessageContent method with the provided content
//   //     AIDTO requestBody = aiService.setMessageContent(content);
//
//        // Fetch AI response
//        ChoicesDTO response = aiService.fetchChoices(content);
//
//        // Add response to the model
//        model.addAttribute("response", response);
//
//        return "ai-message";
//    }
}
