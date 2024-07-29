package bg.softuni.beroe.web;

import bg.softuni.beroe.model.dto.FanSummaryDTO;
import bg.softuni.beroe.model.dto.SearchFanItemsByIdDTO;
import bg.softuni.beroe.model.dto.UserProfileDto;
import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.entity.UserRoleEntity;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import bg.softuni.beroe.service.FanService;
import bg.softuni.beroe.service.UserHelperService;
import bg.softuni.beroe.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OffersControllerTest {

    @Mock
    private FanService fanService;

    @Mock
    private UserHelperService userHelperService;

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private OffersController offersController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
//
//    @Test
//    void testGetAllOffers_AdminRole() {
//        // Arrange
//        UserEntity user = new UserEntity();
//        UserRoleEntity role = new UserRoleEntity();
//        role.setRole(UserRoleEnum.ADMIN);
//        user.setRoles(Collections.singletonList(role));
//        when(userHelperService.getUser()).thenReturn(user);
//        when(userService.getProfileData()).thenReturn(new UserProfileDto());
//        when(fanService.getAllOffersSummary()).thenReturn(Collections.emptyList());
//
//        // Act
//        String viewName = offersController.getAllOffers(model);
//
//        // Assert
//        assertEquals("offers", viewName);
//        verify(fanService, times(1)).getAllOffersSummary();
//        verify(model, times(1)).addAttribute("allOffers", Collections.emptyList());
//    }
//
//    @Test
//    void testGetAllOffers_UserRole() {
//        // Arrange
//        UserEntity user = new UserEntity();
//        UserRoleEntity role = new UserRoleEntity();
//        role.setRole(UserRoleEnum.USER);
//        user.setRoles(Collections.singletonList(role));
//        when(userHelperService.getUser()).thenReturn(user);
//        when(userService.getProfileData()).thenReturn(new UserProfileDto());
//        when(fanService.getOnlyUserOffersSummary()).thenReturn(Collections.emptyList());
//
//        // Act
//        String viewName = offersController.getAllOffers(model);
//
//        // Assert
//        assertEquals("offers", viewName);
//        verify(fanService, times(1)).getOnlyUserOffersSummary();
//        verify(model, times(1)).addAttribute("allOffers", Collections.emptyList());
//    }

    @Test
    void testGetOffersById_ValidId() {
        // Arrange
        SearchFanItemsByIdDTO searchFanItemsByIdDTO = new SearchFanItemsByIdDTO();
        searchFanItemsByIdDTO.setId(1L);
        when(fanService.searchOffersByID(1L)).thenReturn(Collections.emptyList());

        // Act
        String viewName = offersController.getOffersById(searchFanItemsByIdDTO, model);

        // Assert
        assertEquals("offers", viewName);
        verify(fanService, times(1)).searchOffersByID(1L);
        verify(model, times(1)).addAttribute("allOffers", Collections.emptyList());
    }

    @Test
    void testGetOffersById_InvalidId() {
        // Arrange
        SearchFanItemsByIdDTO searchFanItemsByIdDTO = new SearchFanItemsByIdDTO();
        searchFanItemsByIdDTO.setId(-1L);
        when(fanService.getAllOffersSummary()).thenReturn(Collections.emptyList());

        // Act
        String viewName = offersController.getOffersById(searchFanItemsByIdDTO, model);

        // Assert
        assertEquals("offers", viewName);
        verify(fanService, times(1)).getAllOffersSummary();
        verify(model, times(1)).addAttribute("allOffers", Collections.emptyList());
    }
}
