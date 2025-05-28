package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.FilterHouseParameters;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;

public interface HouseServicePort {
    void saveHouse(HouseModel houseModel);
    void updateStateHouses();
    PagedResult<HouseModel> filterHousePaged(FilterHouseParameters params);
    PagedResult<HouseModel> filterHouseByCityNamePaged(FilterHouseParameters params);
}
