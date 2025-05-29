package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.models.FilterHouseByCityNameParams;
import com.daviddiazm.housing.category.domain.models.FilterHouseParameters;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;

import java.util.List;

public interface HousePersistencePort {
    void saveHouse(HouseModel houseModel);
    List<HouseModel> getAllTodayPausedHouses();
    void saveAllHouses(List<HouseModel> houseModels);
    PagedResult<HouseModel> filterHousePaged(FilterHouseParameters params);
    PagedResult<HouseModel> filterHouseByCityNamePaged(FilterHouseByCityNameParams params);
}
