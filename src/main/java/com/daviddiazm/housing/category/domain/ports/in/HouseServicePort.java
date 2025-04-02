package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.HouseModel;

public interface HouseServicePort {
    void saveHouse(HouseModel houseModel);
    void updateStateHouses();
}
