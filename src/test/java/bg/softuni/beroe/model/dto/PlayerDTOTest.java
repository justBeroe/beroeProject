package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.dto.PlayerDTO;
import bg.softuni.beroe.model.dto.PlayerDTO.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerDTOTest {

    @Test
    public void testPlayerDTO() {
        PlayerDTO playerDTO = new PlayerDTO();

        // Test simple fields
        playerDTO.setGet("getRequest");
        assertEquals("getRequest", playerDTO.getGet());

        playerDTO.setResults(1);
        assertEquals(1, playerDTO.getResults());

        // Test nested Parameters class
        Parameters parameters = new Parameters();
        parameters.setLeague("Premier League").setSeason("2021/2022").setTeam("Team A");
        playerDTO.setParameters(parameters);
        assertEquals("Premier League", playerDTO.getParameters().getLeague());
        assertEquals("2021/2022", playerDTO.getParameters().getSeason());
        assertEquals("Team A", playerDTO.getParameters().getTeam());

        // Test nested Paging class
        Paging paging = new Paging();
        paging.setCurrent(1).setTotal(10);
        playerDTO.setPaging(paging);
        assertEquals(1, playerDTO.getPaging().getCurrent());
        assertEquals(10, playerDTO.getPaging().getTotal());

        // Test nested PlayerResponse class
        Player player = new Player();
        player.setId(1).setName("Player Name").setFirstname("First").setLastname("Last").setAge(25);
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setPlayer(player).setStatistics(Collections.emptyList());
        playerDTO.setResponse(Collections.singletonList(playerResponse));

        assertEquals(1, playerDTO.getResponse().get(0).getPlayer().getId());
        assertEquals("Player Name", playerDTO.getResponse().get(0).getPlayer().getName());
    }
}
