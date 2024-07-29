package bg.softuni.beroe.web;




import bg.softuni.beroe.model.dto.FanDetailsDTO;
import bg.softuni.beroe.model.enums.FanSizeEnum;
import bg.softuni.beroe.service.FanService;
import bg.softuni.beroe.service.UserHelperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FanService fanService;

    @MockBean
    private UserHelperService userHelperService;

    @BeforeEach
    void setUp() {
        // Sample data for FanDetailsDTO
        FanDetailsDTO sampleFanDetailsDTO = new FanDetailsDTO(
                1L,
                "Sample Fan Description",
                "Sample Fan Item",
                150,
                FanSizeEnum.M,
                "http://example.com/fan.jpg",
                Arrays.asList("USD", "EUR", "GBP")
        );

        // Mocking the FanService methods
        given(fanService.getOfferDetails(1L)).willReturn(sampleFanDetailsDTO);
    }

    @Test
    void testOfferDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/offers/1")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("details"))
                .andExpect(MockMvcResultMatchers.model().attribute("offerDetails", new FanDetailsDTO(
                        1L,
                        "Sample Fan Description",
                        "Sample Fan Item",
                        150,
                        FanSizeEnum.M,
                        "http://example.com/fan.jpg",
                        Arrays.asList("USD", "EUR", "GBP")
                )));
    }

    // You can include other tests similarly

}