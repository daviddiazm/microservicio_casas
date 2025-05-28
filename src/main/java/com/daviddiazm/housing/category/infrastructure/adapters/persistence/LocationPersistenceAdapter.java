package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.ports.out.LocationPersistencePort;
import com.daviddiazm.housing.category.infrastructure.entities.LocationEntity;
import com.daviddiazm.housing.category.infrastructure.mappers.LocationEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.LocationRepository;
import com.daviddiazm.housing.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {

    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public void saveLocation(LocationModel locationModel) {
        locationRepository.save(locationEntityMapper.modelToEntity(locationModel));
    }

    @Override
    public PagedResult<LocationModel> getLocationsPaginated(int page, int size, boolean orderAsc, String name) {
        Pageable pagination = PageRequest.of(page, size, Sort.by(orderAsc ? Sort.Direction.ASC : Sort.Direction.DESC, Constants.PAGEABLE_FIELD_SECTOR));

        Page<LocationEntity> locationEntityPage = locationRepository.locationsByMunicipalityOrDepartmentName(name, pagination);

        long totalElements = locationRepository.countAllLocations(name);

        return new PagedResult<>(
                locationEntityMapper.entityListToModelList(locationEntityPage.getContent()),
                page,
                size,
                orderAsc,
                totalElements,
                locationEntityPage.getTotalPages()
        );
    }

    @Override
    public List<LocationModel> getLocationsByCityId(long cityId) {
        List<LocationModel> locations = locationEntityMapper.entityListToModelList(locationRepository.getLocationByCiyId(cityId));
        if(locations != null) {
            return locations;
        }
        return List.of();
    }

}
