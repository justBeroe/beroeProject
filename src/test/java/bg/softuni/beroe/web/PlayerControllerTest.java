package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.PlayerDTO;
import bg.softuni.beroe.service.PlayerService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private Gson gson;

    @Mock
    private Model model;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testGetPlayer() throws IOException {
//        // Given
//        PlayerDTO mockPlayerDTO = new PlayerDTO();
//        mockPlayerDTO.setGet("someGet").setResults(1);
//
//        when(playerService.readJson(any(Gson.class))).thenReturn(mockPlayerDTO);
//        when(playerService.fetchAndSavePlayer()).thenReturn(mockPlayerDTO);
//
//        // When
//        String viewName = playerController.getPlayer(model);
//
//        // Then
//        verify(model, times(1)).addAttribute("player", mockPlayerDTO);
//        assertEquals("player", viewName);
//    }

    @Test
    void testFetchAndSavePlayer() throws IOException {
        // Given
        PlayerDTO mockPlayerDTO = new PlayerDTO();
        mockPlayerDTO.setGet("someGet").setResults(1);

        when(playerService.fetchAndSavePlayer()).thenReturn(mockPlayerDTO);

        // When
        String viewName = playerController.fetchAndSavePlayer(model);

        // Then
        verify(model, times(1)).addAttribute("player", mockPlayerDTO);
        assertEquals("redirect:/player", viewName);
    }
}
