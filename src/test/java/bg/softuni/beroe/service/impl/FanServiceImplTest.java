package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.dto.AddOfferDTO;
import bg.softuni.beroe.model.dto.FanDetailsDTO;
import bg.softuni.beroe.model.dto.FanSummaryDTO;
import bg.softuni.beroe.model.entity.FanEntity;
import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.enums.FanSizeEnum;
import bg.softuni.beroe.repository.FanRepository;
import bg.softuni.beroe.service.ExRateService;
import bg.softuni.beroe.service.UserHelperService;
import bg.softuni.beroe.service.exception.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FanServiceImplTest {

    @Mock
    private RestClient offerRestClient;

    @Mock
    private FanRepository fanRepository;

    @Mock
    private ExRateService exRateService;

    @Mock
    private UserHelperService userHelperService;

    @InjectMocks
    private FanServiceImpl fanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void createOffer() {
//        AddOfferDTO addOfferDTO = new AddOfferDTO("description", "item", 100, null, FanSizeEnum.S, "imageUrl");
//        FanEntity fanEntity = new FanEntity();
//        UserEntity userEntity = new UserEntity();
//
//        when(userHelperService.getUser()).thenReturn(userEntity);
//        when(fanRepository.save(any(FanEntity.class))).thenReturn(fanEntity);
//
//        long result = fanService.createOffer(addOfferDTO);
//
//        assertNotNull(result);
//        verify(fanRepository, times(1)).save(any(FanEntity.class));
//    }

    @Test
    void deleteOffer() {
        long offerId = 1L;

        doNothing().when(fanRepository).deleteById(offerId);

        fanService.deleteOffer(offerId);

        verify(fanRepository, times(1)).deleteById(offerId);
    }

    @Test
    void getOfferDetails() {
        long offerId = 1L;
        FanEntity fanEntity = new FanEntity();
        fanEntity.setId(offerId);
        fanEntity.setDescription("description");
        fanEntity.setItem("item");
        fanEntity.setPrice(100);
        fanEntity.setFanSize(FanSizeEnum.S);
        fanEntity.setImageUrl("imageUrl");

        when(fanRepository.findById(offerId)).thenReturn(Optional.of(fanEntity));
        when(exRateService.allSupportedCurrencies()).thenReturn(List.of("USD", "EUR"));

        FanDetailsDTO result = fanService.getOfferDetails(offerId);

        assertNotNull(result);
        assertEquals(offerId, result.id());
        assertEquals("description", result.description());
        assertEquals("item", result.item());
        assertEquals(100, result.price());
        assertEquals(FanSizeEnum.S, result.fanSize());
        assertEquals("imageUrl", result.imageUrl());
        assertEquals(List.of("USD", "EUR"), result.allCurrencies());
        verify(fanRepository, times(1)).findById(offerId);
    }

    @Test
    void getOfferDetails_NotFound() {
        long offerId = 1L;

        when(fanRepository.findById(offerId)).thenReturn(Optional.empty());

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            fanService.getOfferDetails(offerId);
        });

        assertEquals("No offers found with id: " + offerId, exception.getMessage());
    }

    @Test
    void getAllOffersSummary() {
        FanEntity fanEntity = new FanEntity();
        fanEntity.setId(1L);
        fanEntity.setDescription("description");
        fanEntity.setItem("item");
        fanEntity.setPrice(100);
        fanEntity.setFanSize(FanSizeEnum.S);
        fanEntity.setImageUrl("imageUrl");
        fanEntity.setUser(new UserEntity());

        when(fanRepository.findAll()).thenReturn(List.of(fanEntity));

        List<FanSummaryDTO> result = fanService.getAllOffersSummary();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("description", result.get(0).description());
        verify(fanRepository, times(1)).findAll();
    }

    @Test
    void updateFanPrice() {
        long fanId = 1L;
        int newPrice = 150;

        doNothing().when(fanRepository).updatePriceById(fanId, newPrice);

        fanService.updateFanPrice(fanId, newPrice);

        verify(fanRepository, times(1)).updatePriceById(fanId, newPrice);
    }

    @Test
    void updateAllFanPrices() {
        FanEntity fanEntity1 = new FanEntity();
        fanEntity1.setPrice(100);
        FanEntity fanEntity2 = new FanEntity();
        fanEntity2.setPrice(200);
        List<FanEntity> fanEntities = List.of(fanEntity1, fanEntity2);

        when(fanRepository.findAll()).thenReturn(fanEntities);
        when(fanRepository.saveAll(anyList())).thenReturn(fanEntities);

        fanService.updateAllFanPrices();

        assertEquals(101, fanEntity1.getPrice());
        assertEquals(201, fanEntity2.getPrice());
        verify(fanRepository, times(1)).findAll();
        verify(fanRepository, times(1)).saveAll(fanEntities);
    }
}
