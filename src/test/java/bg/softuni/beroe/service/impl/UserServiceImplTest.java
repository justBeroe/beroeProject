package bg.softuni.beroe.service.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import bg.softuni.beroe.model.dto.UserRegistrationDTO;
import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.repository.UserRepository;
import bg.softuni.beroe.repository.UserRoleRepository;
import bg.softuni.beroe.service.UserHelperService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private UserServiceImpl toTest;

    @Captor
    private ArgumentCaptor<UserEntity> userEntityCaptor;

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private PasswordEncoder mockPasswordEncoder;

    @Mock
    private UserRoleRepository mockUserRoleRepository;

    @Mock
    private UserHelperService mockUserHelperService;

    @BeforeEach
    void setUp() {

        toTest = new UserServiceImpl(
                new ModelMapper(),
                mockPasswordEncoder,
                mockUserRepository,
                mockUserRoleRepository,
                mockUserHelperService
        );

    }

    @Test
    void testUserRegistration() {

      // Arrange

        UserRegistrationDTO userRegistrationDTO =
                new UserRegistrationDTO()
                        .setFirstName("Anna")
                        .setLastName("Dimitrova")
                        .setPassword("topsecret")
                        .setUsername("anna");

        when(mockPasswordEncoder.encode(userRegistrationDTO.getPassword()))
                .thenReturn(userRegistrationDTO.getPassword() + userRegistrationDTO.getPassword());


        // ACT
        toTest.registerUser(userRegistrationDTO);

        // Assert
        verify(mockUserRepository).save(userEntityCaptor.capture());

        UserEntity actualSavedEntity = userEntityCaptor.getValue();

        Assertions.assertNotNull(actualSavedEntity);
        Assertions.assertEquals(userRegistrationDTO.getFirstName(), actualSavedEntity.getFirstName());
        Assertions.assertEquals(userRegistrationDTO.getLastName(), actualSavedEntity.getLastName());
        Assertions.assertEquals(userRegistrationDTO.getPassword() + userRegistrationDTO.getPassword(),
                actualSavedEntity.getPassword());
        Assertions.assertEquals(userRegistrationDTO.getUsername(), actualSavedEntity.getUsername());
    }

}
