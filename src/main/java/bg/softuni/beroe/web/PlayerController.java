package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.PlayerDTO;
import bg.softuni.beroe.service.PlayerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.io.IOException;
import java.util.List;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired // !! Field injection is not recommended. Field, Method or Setter [not common injection]
    @Qualifier("withNulls") //Field, Method, Constructor, etc.
    private Gson gson;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player")
    public String getPlayer( Model model) throws IOException {
        // Example service call to fetch player details
       // String s = playerService.fetchPlayerJson();
      //  System.out.println(s);
        PlayerDTO playerDTO = playerService.readJson(gson);
         PlayerDTO playerDTO1 = playerService.fetchAndSavePlayer();
    //    System.out.println(playerDTO);
       model.addAttribute("player", playerDTO);
       playerService.savePlayers();
        return "player"; // Returns the player.html Thymeleaf template
    }

    @PostMapping("/fetchPlayer")
    public String fetchAndSavePlayer(Model model) throws IOException {
        // Fetch and save playerDTO1 on button click
        PlayerDTO playerDTO1 = playerService.fetchAndSavePlayer();
        model.addAttribute("player", playerDTO1);
        return "redirect:/player"; // Redirect to the same page to reflect the update
    }


}
