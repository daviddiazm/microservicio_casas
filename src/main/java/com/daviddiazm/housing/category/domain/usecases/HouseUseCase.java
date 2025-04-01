package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.ports.in.HouseServicePort;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;

public class HouseUseCase implements HouseServicePort {

    private final HousePersistencePort housePersistencePort;

    public HouseUseCase(HousePersistencePort housePersistencePort) {
        this.housePersistencePort = housePersistencePort;
    }

    @Override
    public void saveHouse(HouseModel houseModel) {
//        falta validaciones
        housePersistencePort.saveHouse(houseModel);
    }
}
