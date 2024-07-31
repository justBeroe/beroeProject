package bg.softuni.beroe.service;

import bg.softuni.beroe.model.dto.PlayerDTO;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PlayerService {

    PlayerDTO fetchPlayer();

    void savePlayers() throws FileNotFoundException;

    void savePlayerToJson(PlayerDTO playerDTO, String filename) throws IOException;

    PlayerDTO fetchAndSavePlayer() throws IOException;
    String fetchPlayerJson();

    PlayerDTO readJson(Gson gson) throws FileNotFoundException;

}
