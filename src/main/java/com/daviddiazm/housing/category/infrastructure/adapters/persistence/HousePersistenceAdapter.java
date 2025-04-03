package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.enums.PublishState;
import com.daviddiazm.housing.category.domain.models.*;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;
import com.daviddiazm.housing.category.infrastructure.entities.HouseEntity;
import com.daviddiazm.housing.category.infrastructure.mappers.HouseEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.HouseRepository;
import com.daviddiazm.housing.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HousePersistenceAdapter implements HousePersistencePort {

    private final HouseRepository houseRepository;
    private final HouseEntityMapper houseEntityMapper;

    @Override
    public void saveHouse(HouseModel houseModel) {
        houseRepository.save(houseEntityMapper.modelToEntity(houseModel));
    }

    @Override
    public List<HouseModel> getAllTodayPausedHouses() {
        return houseEntityMapper.listEntityToListModel(houseRepository.getAllTodayPausedHouses());
    }

    @Override
    public void saveAllHouses(List<HouseModel> houseModels) {
        houseRepository.saveAll(houseEntityMapper.listModelToListEntity(houseModels));
    }

    @Override
    public PagedResult<HouseModel> filterHousePaged(FilterHouseParameters params) {
        int page = params.getPage();
        int size = params.getSize();
        boolean orderAsc = params.isOrderAsc();
        Long location = params.getIdLocation();
        Long category = params.getIdCategory();
        int roomsQuantity = params.getRoomsQuantity();
        int bathroomsQuantity = params.getBathroomsQuantity();
        double minPrice = params.getMinPrice();
        double maxPrice = params.getMaxPrice();

        Pageable pagination;
        if (orderAsc) {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        }

        Page<HouseEntity> houseEntities = houseRepository.findHouses(location, category, roomsQuantity, bathroomsQuantity, minPrice, maxPrice, pagination);
        return new PagedResult<>(
                houseEntityMapper.listEntityToListModel(houseEntities.getContent()),
                pagination.getPageNumber(),
                houseEntities.getSize(),
                orderAsc,
                houseEntities.getTotalElements(),
                houseEntities.getTotalPages()
        );
    }
}
