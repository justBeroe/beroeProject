//package bg.softuni.beroe.service.impl;
//
//import bg.softuni.beroe.model.dto.PlayerDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//import org.springframework.web.client.RestClient;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//public class PlayerServiceImplTest {
//
//    private RestClient restClient;
//    private ObjectMapper objectMapper;
//    private Gson gson;
//    private PlayerServiceImpl playerService;
//
//    @BeforeEach
//    void setUp() {
//        // Initialize mocks
//        restClient = mock(RestClient.class);
//        objectMapper = mock(ObjectMapper.class);
//        gson = mock(Gson.class);
//
//        // Create an instance of PlayerServiceImpl with mocks
//        playerService = new PlayerServiceImpl(restClient, objectMapper);
//
//        // Set the gson field manually using reflection
//        try {
//            java.lang.reflect.Field gsonField = PlayerServiceImpl.class.getDeclaredField("gson");
//            gsonField.setAccessible(true);
//            gsonField.set(playerService, gson);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace(); // Handle the exception as needed
//        }
//    }
//
//    @Test
//    void testFetchPayer() {
//        // Given
//        PlayerDTO mockPlayerDTO = new PlayerDTO();
//        mockPlayerDTO.setGet("someGet").setResults(1);
//
//        // Create mocks for RestClient methods
//        RestClient.RequestHeadersUriSpec requestHeadersUriSpec = mock(RestClient.RequestHeadersUriSpec.class);
//        RestClient.RequestHeadersSpec requestHeadersSpec = mock(RestClient.RequestHeadersSpec.class);
//        RestClient.ResponseSpec responseSpec = mock(RestClient.ResponseSpec.class);
//
//        // Set up the mock behavior
//        when(restClient.get()).thenReturn(requestHeadersUriSpec);
//        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
//        when(requestHeadersSpec.header(anyString(), anyString())).thenReturn(requestHeadersSpec);
//        when(requestHeadersSpec.accept(any(MediaType.class))).thenReturn(requestHeadersSpec);
//        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
//        when(responseSpec.body(eq(PlayerDTO.class))).thenReturn(mockPlayerDTO);
//
//        // When
//        PlayerDTO result = playerService.fetchPlayer();
//
//        // Then
//        assertEquals(mockPlayerDTO, result);
//    }
//
////    @Test
////    void testFetchAndSavePlayer() throws Exception {
////        // Given
////        PlayerDTO mockPlayerDTO = new PlayerDTO();
////        mockPlayerDTO.setGet("someGet").setResults(1);
////
////        // Mock fetchPayer method
////        when(playerService.fetchPayer()).thenReturn(mockPlayerDTO);
////
////        // Mock objectMapper behavior
////        doNothing().when(objectMapper).writeValue(any(File.class), eq(mockPlayerDTO));
////
////        // When
////        PlayerDTO result = playerService.fetchAndSavePlayer();
////
////        // Then
////        verify(objectMapper, times(1)).writeValue(any(File.class), eq(mockPlayerDTO));
////        assertEquals(mockPlayerDTO, result);
////    }
//
//    @Test
//    void testReadJson() throws FileNotFoundException {
//        // Given
//        PlayerDTO mockPlayerDTO = new PlayerDTO();
//        mockPlayerDTO.setGet("someGet").setResults(1);
//
//        // Mock Gson behavior
//        when(gson.fromJson(any(FileReader.class), eq(PlayerDTO.class))).thenReturn(mockPlayerDTO);
//
//        // When
//        PlayerDTO result = playerService.readJson(gson);
//
//        // Then
//        assertEquals(mockPlayerDTO, result);
//    }
//
//    @Test
//    void testSavePlayerToJson() throws IOException {
//        // Given
//        PlayerDTO mockPlayerDTO = new PlayerDTO();
//        mockPlayerDTO.setGet("someGet").setResults(1);
//
//        // When
//        playerService.savePlayerToJson(mockPlayerDTO, "test.json");
//
//        // Then
//        verify(objectMapper, times(1)).writeValue(any(File.class), eq(mockPlayerDTO));
//    }
//
//    @Test
//    void testFetchPlayerJson() {
//        // Given
//        String mockJson = "{\"get\":\"someGet\",\"results\":1}";
//
//        // Create mocks for RestClient methods
//        RestClient.RequestHeadersUriSpec requestHeadersUriSpec = mock(RestClient.RequestHeadersUriSpec.class);
//        RestClient.RequestHeadersSpec requestHeadersSpec = mock(RestClient.RequestHeadersSpec.class);
//        RestClient.ResponseSpec responseSpec = mock(RestClient.ResponseSpec.class);
//
//        // Set up the mock behavior
//        when(restClient.get()).thenReturn(requestHeadersUriSpec);
//        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
//        when(requestHeadersSpec.header(anyString(), anyString())).thenReturn(requestHeadersSpec);
//        when(requestHeadersSpec.accept(any(MediaType.class))).thenReturn(requestHeadersSpec);
//        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
//        when(responseSpec.body(eq(String.class))).thenReturn(mockJson);
//
//        // When
//        String result = playerService.fetchPlayerJson();
//
//        // Then
//        assertEquals(mockJson, result);
//    }
//}
