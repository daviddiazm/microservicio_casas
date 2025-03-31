package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.ports.out.LocationPersistencePort;
import com.daviddiazm.housing.category.infrastructure.entities.LocationEntity;
import com.daviddiazm.housing.category.infrastructure.mappers.LocationEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {

    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public void saveLocation(LocationModel locationModel) {
//        LocationEntity locationEntity = new LocationEntity(null, locationModel.getSector(), null);
////        LocationModel location = new LocationModel(locationEntity.getId(), locationEntity.getSector(), null);
        locationRepository.save(locationEntityMapper.modelToEntity(locationModel));
    }
}
