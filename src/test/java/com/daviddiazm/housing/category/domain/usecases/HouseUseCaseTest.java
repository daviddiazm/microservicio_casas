package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;
import com.daviddiazm.housing.category.domain.utils.factories.HouseFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class HouseUseCaseTest {

    @Mock
    HousePersistencePort housePersistencePort;

    @InjectMocks
    HouseUseCase houseUseCase;

    @Test
    void saveHouse_ValidHouse_SaveHouse() {
        HouseModel house = HouseFactory.createHouse();

    }
}