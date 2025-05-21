package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;

public interface LocationServicePort {
    void saveLocation(LocationModel locationModel);
    PagedResult<LocationModel> getLocationsPaginated (int page, int size, boolean orderAsc, String name);
}
