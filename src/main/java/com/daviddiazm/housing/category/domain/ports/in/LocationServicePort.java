package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.LocationModel;

public interface LocationServicePort {
    void saveLocation(LocationModel locationModel);
}
