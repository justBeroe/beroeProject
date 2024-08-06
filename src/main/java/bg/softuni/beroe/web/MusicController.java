package bg.softuni.beroe.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class MusicController {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String DEEZER_API_URL = "https://api.deezer.com/artist/85/top?limit=10";

    @GetMapping("/top10")
    public String showTopSongs(Model model) {
        Map<String, Object> songs = restTemplate.getForObject(DEEZER_API_URL, Map.class);
        model.addAttribute("songs", songs.get("data"));
        return "top10";
    }
}

