package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.enums.PublishState;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;
import com.daviddiazm.housing.category.domain.utils.factories.HouseFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HouseUseCaseTest {

    @Mock
    HousePersistencePort housePersistencePort;

    @InjectMocks
    HouseUseCase houseUseCase;

    @Test
    void saveHouse_ValidHouse_SaveHouse() {
        HouseModel house = HouseFactory.createHouse();
        houseUseCase.saveHouse(house);
        verify(housePersistencePort).saveHouse(house);
    }


    @Test
    void updateStateHouses_verify_thanSaveHouses () {
        HouseModel house = HouseFactory.createHouse();
        house.setPublishDate(LocalDate.of(2025,4,2));
        house.setPublishState(PublishState.PUBLICACION_PAUSADA);
        when(housePersistencePort.getAllTodayPausedHouses()).thenReturn(List.of(house));

        houseUseCase.updateStateHouses();
        assertEquals(PublishState.PUBLICADA, house.getPublishState());
    }

}