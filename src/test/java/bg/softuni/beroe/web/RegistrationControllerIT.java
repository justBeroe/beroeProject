package bg.softuni.beroe.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Optional;

import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import bg.softuni.beroe.repository.UserRepository;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  //@MockBean
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  void testRegistration() throws Exception {

    UserRoleEnum role = UserRoleEnum.USER;
      String name = role.name();

      MvcResult result = mockMvc.perform(post("/users/register")
                    .param("username", "beroe12")
                    .param("firstName", "Dobromir")
                    .param("lastName", "Todorov")
                    .param("password", "beroe12")
                   .param("role", name) // Add role as a parameter
                    .with(csrf())
            ).andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/"))
            .andReturn();
    System.out.println();

   Optional<UserEntity> userEntityOpt = userRepository.findByUsername("beroe12");

    Assertions.assertTrue(userEntityOpt.isPresent());

    UserEntity userEntity = userEntityOpt.get();

    Assertions.assertEquals("Dobromir", userEntity.getFirstName());
    Assertions.assertEquals("Todorov", userEntity.getLastName());

    Assertions.assertTrue(passwordEncoder.matches("beroe12", userEntity.getPassword()));
  }
}
