package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.GetLocationsRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveLocationRequest;
import com.daviddiazm.housing.category.application.dtos.responses.LocationResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveLocationResponse;
import com.daviddiazm.housing.category.application.mappers.LocationDtoMapper;
import com.daviddiazm.housing.category.application.services.LocationService;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.ports.in.LocationServicePort;
import com.daviddiazm.housing.category.domain.utils.constants.LocationConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImp implements LocationService {

    private final LocationDtoMapper locationDtoMapper;
    private final LocationServicePort locationServicePort;

    @Override
    public SaveLocationResponse saveLocation(SaveLocationRequest saveLocationRequest) {
        locationServicePort.saveLocation(locationDtoMapper.requestToModel(saveLocationRequest));
        return new SaveLocationResponse(LocationConstants.SAVE_CORRECTLY_MESSAGE, LocalDate.now());
    }

    @Override
    public PagedResult<LocationModel> getLocationsPaginated(GetLocationsRequest request) {
        int page = request.page();
        int size = request.size();
        boolean orderAc = request.orderAsc();
        String name = request.name();
        return locationServicePort.getLocationsPaginated(page,size,orderAc,name);
    }

    @Override
    public List<LocationResponse> getLocationsByCityId(long cityId) {
        return locationDtoMapper.modelListToRequestList(locationServicePort.getLocationsByCityId(cityId)) ;
    }
}
