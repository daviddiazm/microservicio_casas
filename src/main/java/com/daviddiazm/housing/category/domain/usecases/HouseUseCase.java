package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.ports.in.HouseServicePort;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;
import com.daviddiazm.housing.category.domain.utils.validations.HouseValidator;

import java.time.LocalDate;

public class HouseUseCase implements HouseServicePort {

    private final HousePersistencePort housePersistencePort;

    public HouseUseCase(HousePersistencePort housePersistencePort) {
        this.housePersistencePort = housePersistencePort;
    }

    @Override
    public void saveHouse(HouseModel houseModel) {
        HouseValidator.validateName(houseModel.getName());
        HouseValidator.validateDescription(houseModel.getDescription());
        HouseValidator.validateRooms(houseModel.getRoomsQuantity());
        HouseValidator.validateBathRooms(houseModel.getBathroomsQuantity());
        HouseValidator.validateAdress(houseModel.getAddress());
        HouseValidator.validatePublishDate(houseModel.getPublishDate());

        houseModel.setCreateDate(LocalDate.now());
        housePersistencePort.saveHouse(houseModel);
    }
}
