package bg.softuni.beroe.service.impl;


import bg.softuni.beroe.model.dto.PlayerDTO;
import bg.softuni.beroe.model.entity.PlayerEntity;
import bg.softuni.beroe.repository.PlayerRepository;
import bg.softuni.beroe.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired // !! Field injection is not recommended. Field, Method or Setter [not common injection]
    @Qualifier("withNulls") //Field, Method, Constructor, etc.
    private Gson gson;

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerServiceImpl(@Qualifier("getPlayers") RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;

    }

    @Override
    public PlayerDTO fetchPlayer() {

        PlayerDTO body = restClient
                .get()
                .uri("https://v3.football.api-sports.io/players?league=172&season=2024&team=857")
                .header("x-rapidapi-key", "5973cf32b2ce98b416e55c6cedf575c4")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(PlayerDTO.class);
        System.out.println(body);
        return body;
    }



    public PlayerDTO readJson(Gson gson) throws FileNotFoundException {
        File jsonFile = new File("C:\\Users\\up636306\\Desktop\\PythonSoftUni\\Spring Advanced\\FinalProject\\src\\main\\resources\\player.json");
        String json = String.valueOf(jsonFile);
        FileReader reader = new FileReader(jsonFile);
        PlayerDTO playerDTO = gson.fromJson(reader, PlayerDTO.class);
        PlayerDTO[] playerDTOS = gson.fromJson(reader, PlayerDTO[].class);
//        System.out.println(playerDTO);
//        System.out.println(playerDTOS);

        return playerDTO;

    }

    @Override
    public void savePlayers() throws FileNotFoundException {
        PlayerDTO playerDTO = readJson(new Gson());

        // Convert PlayerDTO to PlayerEntity
        //PlayerEntity playerEntity = new PlayerEntity();
        List<PlayerEntity> playerEntityList = new ArrayList<>();

        for (PlayerDTO.PlayerResponse response : playerDTO.getResponse()) {
            PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.setPlayerName(response.getPlayer().getName()); // Adjust according to actual fields
            playerEntity.setPosition(response.getStatistics().get(0).getGames().getPosition()); // Adjust according to actual fields
            playerEntityList.add(playerEntity);
        }

        // Save the list of PlayerEntity to the database
        if (!playerEntityList.isEmpty()) {
            if (playerRepository.count() <= 0 ) {
                playerRepository.saveAll(playerEntityList);
                System.out.println("Players saved to the database.");
            }
        } else {
            System.out.println("No players to save.");
        }

    }

    @Override
    public String fetchPlayerJson() {
        String jsonResponse = restClient
                .get()
                .uri("https://v3.football.api-sports.io/players?league=172&season=2024&team=857")
                .header("x-rapidapi-key", "5973cf32b2ce98b416e55c6cedf575c4")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class); // Fetch the response body as a String
                 // Block and wait for the response

        System.out.println(jsonResponse); // Print the raw JSON
        return jsonResponse; // Return the raw JSON as a String

    }

    public void savePlayerToJson(PlayerDTO playerDTO, String filename) throws IOException {
        // Specify the resources folder path
        File resourceFolder = new File("src/main/resources");
        if (!resourceFolder.exists()) {
            resourceFolder.mkdirs();
        }

        // Create the JSON file in the resources folder
        File jsonFile = new File(resourceFolder, filename);

        // Write the PlayerDTO object to the JSON file
        objectMapper.writeValue(jsonFile, playerDTO);
    }

    // Example method to fetch and save player data
    public PlayerDTO fetchAndSavePlayer() throws IOException {
        PlayerDTO playerDTO = fetchPlayer();
        savePlayerToJson(playerDTO, "player.json");
        return playerDTO;
    }
}
