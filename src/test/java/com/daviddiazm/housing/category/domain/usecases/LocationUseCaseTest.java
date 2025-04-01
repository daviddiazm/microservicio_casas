package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.MunicipalityNotExistException;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.ports.out.LocationPersistencePort;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.domain.utils.factories.LocationFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationUseCaseTest {

    @Mock
    private LocationPersistencePort locationPersistencePort;

    @Mock
    private MunicipalityPersistencePort municipalityPersistencePort;

    @InjectMocks
    private LocationUseCase locationUseCase;

    @Test
    void saveLocation_ValidMunicipality_SavesLocation() {
        LocationModel locationModel = LocationFactory.createLocation();
        when(municipalityPersistencePort.findById(locationModel.getMunicipalityModel().getId())).thenReturn(locationModel.getMunicipalityModel());

        locationUseCase.saveLocation(locationModel);

        verify(locationPersistencePort, times(1)).saveLocation(locationModel);
        assertEquals("santa lucia", locationModel.getSector().toLowerCase());
    }

    @Test
    void saveLocation_MunicipalityNotFound_ThrowsMunicipalityNotExistException() {
        LocationModel locationModel = LocationFactory.createLocation();

        when(municipalityPersistencePort.findById(1L)).thenReturn(null);

        assertThrows(MunicipalityNotExistException.class, () -> locationUseCase.saveLocation(locationModel));
        verify(municipalityPersistencePort, times(1)).findById(1L);
        verify(locationPersistencePort, never()).saveLocation(any());
    }

}