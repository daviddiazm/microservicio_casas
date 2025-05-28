package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.MunicipalityNotExistException;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.ports.in.LocationServicePort;
import com.daviddiazm.housing.category.domain.ports.out.LocationPersistencePort;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.LocationConstants;
import com.daviddiazm.housing.category.domain.utils.validations.LocationValidator;
import com.daviddiazm.housing.category.domain.utils.validations.PageResultValidator;

import java.util.List;

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

    @Override
    public PagedResult<LocationModel> getLocationsPaginated(int page, int size, boolean orderAsc, String name) {
        PageResultValidator.validatePage(page);
        PageResultValidator.validateSize(size);
        String lowerName = name.toLowerCase();
        return locationPersistencePort.getLocationsPaginated(page, size, orderAsc,lowerName);
    }

    @Override
    public List<LocationModel> getLocationsByCityId(long cityId) {
        List<LocationModel> locations = locationPersistencePort.getLocationsByCityId(cityId);
        if(locations.isEmpty()) {
            return List.of();
        }
        return locations;
    }
}
