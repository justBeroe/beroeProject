package bg.softuni.beroe.service.impl;

import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;

import bg.softuni.beroe.model.entity.UserRoleEntity;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import bg.softuni.beroe.model.user.BeroeUserDetails;
import bg.softuni.beroe.repository.UserRepository;
import bg.softuni.beroe.model.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
class BeroeUserDetailsServiceTest {

  private static final String TEST_USERNAME = "userTest";
  private static final String NOT_EXISTENT_USERNAME = "nooneuser";

  private BeroeUserDetailsService toTest;

  // Arrange ---> AAA
  @Mock
  // To use Annotation with Junit 5 ---> should be set to @ExtendWith(MockitoExtension.class)
  private UserRepository mockUserRepository;

  @BeforeEach
  void setUp() {
    // OR UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

    toTest = new BeroeUserDetailsService(mockUserRepository);
  }

  @Test
  void testLoadUserByUsername_UserFound() {

    // Arrange
    UserEntity testUser = new UserEntity()
        .setUsername(TEST_USERNAME)
        .setPassword("topsecret")
        .setFirstName("Pesho")
        .setLastName("Petrov")
        .setRoles(List.of(
            new UserRoleEntity().setRole(UserRoleEnum.ADMIN),
            new UserRoleEntity().setRole(UserRoleEnum.USER)
        ));

    when(mockUserRepository.findByUsername(TEST_USERNAME))
        .thenReturn(Optional.of(testUser));

    // OR Mockito.when

    // Act
    UserDetails userDetails = toTest.loadUserByUsername(TEST_USERNAME);

    // Assert
    /// Junit 4 ---> Assert but in Junit 5 ---> Assertions
    Assertions.assertInstanceOf(BeroeUserDetails.class, userDetails);

    BeroeUserDetails mobileleUserDetails = (BeroeUserDetails) userDetails;

    Assertions.assertEquals(TEST_USERNAME, userDetails.getUsername());
    Assertions.assertEquals(testUser.getPassword(), userDetails.getPassword());
    Assertions.assertEquals(testUser.getFirstName(), mobileleUserDetails.getFirstName());
    Assertions.assertEquals(testUser.getLastName(), mobileleUserDetails.getLastName());
    Assertions.assertEquals(testUser.getFirstName() + " " + testUser.getLastName(),
        mobileleUserDetails.getFullName());

    var expectedRoles = testUser.getRoles().stream().map(UserRoleEntity::getRole).map(r -> "ROLE_" + r).toList();
    var actualRoles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

    Assertions.assertEquals(expectedRoles, actualRoles);
  }

  @Test
  void testLoadUserByUsername_UserNotFound() {
    Assertions.assertThrows(
        UsernameNotFoundException.class,
        () -> toTest.loadUserByUsername(NOT_EXISTENT_USERNAME)
    );
  }

}
