package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.UserLoginDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // No additional setup needed for these tests
    }

    @Test
    void testViewLogin() throws Exception {
        mockMvc.perform(get("/users/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-login"))
                .andExpect(model().attributeExists("loginData"))
                .andExpect(model().attribute("loginData", new UserLoginDTO(null, null)));
    }

    @Test
    void testViewLoginError() throws Exception {
        mockMvc.perform(get("/users/login-error"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-login"))
                .andExpect(model().attributeExists("loginData"))
                .andExpect(model().attribute("loginData", new UserLoginDTO(null, null)))
                .andExpect(model().attribute("showErrorMessage", true));
    }
}
