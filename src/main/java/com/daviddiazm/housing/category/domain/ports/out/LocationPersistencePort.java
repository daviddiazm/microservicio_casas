package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.models.LocationModel;

public interface LocationPersistencePort {
    void saveLocation(LocationModel locationModel);
}
