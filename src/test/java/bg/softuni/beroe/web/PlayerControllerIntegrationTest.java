package bg.softuni.beroe.web;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import bg.softuni.beroe.model.dto.PlayerDTO;
import bg.softuni.beroe.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlayerDetailsPage() throws Exception {
        PlayerDTO mockPlayerDTO = new PlayerDTO()
                .setResponse(Arrays.asList(
                        new PlayerDTO.PlayerResponse()
                                .setPlayer(new PlayerDTO.Player()
                                        .setId(1)
                                        .setName("D. Stanchev")
                                        .setNationality("Country")
                                        .setBirth(new PlayerDTO.Birth()
                                                .setDate("2000-01-01"))
                                        .setAge(24)
                                        .setPhoto("http://example.com/photo.jpg"))
                                .setStatistics(Arrays.asList(new PlayerDTO.Statistics())) // Removed setGames
                ));

        when(playerService.fetchAndSavePlayer()).thenReturn(mockPlayerDTO);

        ResultActions resultActions = mockMvc.perform(get("/player"))
                .andExpect(status().isOk())
                .andExpect(view().name("player"))
//                .andExpect(content().string(containsString("Total players 1")))
                .andExpect(content().string(containsString("D. Stanchev")));
        //  .andExpect(content().string(containsString("Country")))
        //        .andExpect(content().string(containsString("2000-01-01")))
    //           .andExpect(content().string(containsString("24")))
      //         .andExpect(content().string(containsString("http://example.com/photo.jpg")));
    }
}
