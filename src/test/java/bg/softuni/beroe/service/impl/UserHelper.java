package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.repository.UserRepository;
import bg.softuni.beroe.service.UserHelperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserHelperServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @Mock
    private UserDetails userDetails;

    @InjectMocks
    private UserHelperService userHelperService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        SecurityContextHolder.setContext(securityContext);
        when(securityContext.getAuthentication()).thenReturn(authentication);
    }

    @Test
    void testGetUser() {
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("testUser");
        UserEntity userEntity = new UserEntity();
        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(userEntity));

        UserEntity result = userHelperService.getUser();

        assertNotNull(result);
        assertEquals(userEntity, result);
    }

    @Test
    void testGetUser_NotFound() {
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userRepository.findByUsername("testUser")).thenReturn(Optional.empty());

        UserEntity result = userHelperService.getUser();

        assertNull(result);
    }

//    @Test
//    void testHasRole() {
//        GrantedAuthority authority = mock(GrantedAuthority.class);
//        when(authority.getAuthority()).thenReturn("ROLE_ADMIN");
//        when(authentication.getAuthorities()).thenReturn(Collections.singleton(authority));
//
//        boolean result = userHelperService.hasRole("ADMIN");
//
//        assertTrue(result);
//    }

//    @Test
//    void testHasRole_False() {
//        GrantedAuthority authority = mock(GrantedAuthority.class);
//        when(authority.getAuthority()).thenReturn("ROLE_USER");
//        when(authentication.getAuthorities()).thenReturn(Collections.singleton(authority));
//
//        boolean result = userHelperService.hasRole("ADMIN");
//
//        assertFalse(result);
//    }

    @Test
    void testGetUserDetails() {
        when(authentication.getPrincipal()).thenReturn(userDetails);

        UserDetails result = userHelperService.getUserDetails();

        assertNotNull(result);
        assertEquals(userDetails, result);
    }

//    @Test
//    void testIsAuthenticated() {
//        GrantedAuthority authority = mock(GrantedAuthority.class);
//        when(authority.getAuthority()).thenReturn("ROLE_USER");
//        when(authentication.getAuthorities()).thenReturn(Collections.singleton(authority));
//
//        boolean result = userHelperService.isAuthenticated();
//
//        assertTrue(result);
//    }

//    @Test
//    void testIsAuthenticated_Anonymous() {
//        GrantedAuthority authority = mock(GrantedAuthority.class);
//        when(authority.getAuthority()).thenReturn("ROLE_ANONYMOUS");
//        when(authentication.getAuthorities()).thenReturn(Collections.singleton(authority));
//
//        boolean result = userHelperService.isAuthenticated();
//
//        assertFalse(result);
//    }

    @Test
    void testGetAuthentication() {
        Authentication result = userHelperService.getAuthentication();

        assertNotNull(result);
        assertEquals(authentication, result);
    }
}
