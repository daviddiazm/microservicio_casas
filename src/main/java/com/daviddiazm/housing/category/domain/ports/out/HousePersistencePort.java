package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.models.HouseModel;

import java.util.List;

public interface HousePersistencePort {
    void saveHouse(HouseModel houseModel);
    List<HouseModel> getAllTodayPausedHouses();
    void saveAllHouses(List<HouseModel> houseModels);
}
