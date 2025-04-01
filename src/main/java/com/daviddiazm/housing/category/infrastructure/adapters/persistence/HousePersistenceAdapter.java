package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.enums.PublishState;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;
import com.daviddiazm.housing.category.infrastructure.entities.HouseEntity;
import com.daviddiazm.housing.category.infrastructure.mappers.HouseEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.HouseRepository;
import lombok.RequiredArgsConstructor;
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

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateStateHouses() {
        LocalDate todayDate = LocalDate.now();
        List<HouseEntity> houses = houseRepository.findAll();
        for (HouseEntity house : houses) {
            if(house.getPublishState() == PublishState.PUBLICACION_PAUSADA && (house.getPublishDate().isAfter(todayDate) || house.getPublishDate().isEqual(todayDate)) ){
                house.setPublishState(PublishState.PUBLICADA);
            }
        }
        houseRepository.saveAll(houses);
    }
}
