package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.MunicipalityNotExistException;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.ports.in.LocationServicePort;
import com.daviddiazm.housing.category.domain.ports.out.LocationPersistencePort;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.LocationConstants;
import com.daviddiazm.housing.category.domain.utils.validations.LocationValidator;

public class LocationUseCase implements LocationServicePort {

    private final LocationPersistencePort locationPersistencePort;
    private final MunicipalityPersistencePort municipalityPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort, MunicipalityPersistencePort municipalityPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
        this.municipalityPersistencePort = municipalityPersistencePort;
    }

    @Override
    public void saveLocation(LocationModel locationModel) {
        locationModel.setSector(locationModel.getSector().toLowerCase());
        MunicipalityModel municipality = municipalityPersistencePort.findById(locationModel.getMunicipalityModel().getId());
        if(municipality == null) {
            throw new MunicipalityNotExistException(LocationConstants.MUNICIPALITY_NO_EXIST);
        }
        locationPersistencePort.saveLocation(locationModel);
    }
}
