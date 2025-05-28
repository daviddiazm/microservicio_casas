package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;

import java.util.List;

public interface LocationServicePort {
    void saveLocation(LocationModel locationModel);
    PagedResult<LocationModel> getLocationsPaginated (int page, int size, boolean orderAsc, String name);
    List<LocationModel> getLocationsByCityId(long cityId);
}
