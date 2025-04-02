package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.enums.PublishState;
import com.daviddiazm.housing.category.domain.models.FilterHouseParameters;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.ports.in.HouseServicePort;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;
import com.daviddiazm.housing.category.domain.utils.validations.HouseValidator;
import com.daviddiazm.housing.category.domain.utils.validations.PageResultValidator;

import java.time.LocalDate;
import java.util.List;

public class HouseUseCase implements HouseServicePort {

    private final HousePersistencePort housePersistencePort;

    public HouseUseCase(HousePersistencePort housePersistencePort) {
        this.housePersistencePort = housePersistencePort;
    }

    @Override
    public void saveHouse(HouseModel houseModel) {
        LocalDate today = LocalDate.now();
        HouseValidator.validateName(houseModel.getName());
        HouseValidator.validateDescription(houseModel.getDescription());
        HouseValidator.validateRooms(houseModel.getRoomsQuantity());
        HouseValidator.validateBathRooms(houseModel.getBathroomsQuantity());
        HouseValidator.validateAdress(houseModel.getAddress());
        HouseValidator.validatePublishDate(houseModel.getPublishDate());

        if(houseModel.getPublishDate().isEqual(today) || houseModel.getPublishDate().isBefore(today)) {
            houseModel.setPublishState(PublishState.PUBLICADA);
        } else {
            houseModel.setPublishState(PublishState.PUBLICACION_PAUSADA);
        }

        houseModel.setCreateDate(LocalDate.now());
        housePersistencePort.saveHouse(houseModel);
    }

    @Override
    public void updateStateHouses() {
        List<HouseModel> houses = housePersistencePort.getAllTodayPausedHouses();
        for (HouseModel house : houses) {
            house.setPublishState(PublishState.PUBLICADA);
        }
        housePersistencePort.saveAllHouses(houses);
    }

    @Override
    public PagedResult<HouseModel> filterHousePaged(FilterHouseParameters params) {
        PageResultValidator.validatePage(params.getPage());
        PageResultValidator.validateSize(params.getSize());
        return housePersistencePort.filterHousePaged(params);
    }
}
