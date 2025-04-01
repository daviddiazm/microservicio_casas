package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.models.HouseModel;

public interface HousePersistencePort {
    void saveHouse(HouseModel houseModel);

}
