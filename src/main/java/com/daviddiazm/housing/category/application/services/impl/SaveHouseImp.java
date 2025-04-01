package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveHouseResponse;
import com.daviddiazm.housing.category.application.mappers.HouseDtoMapper;
import com.daviddiazm.housing.category.application.services.HouseService;
import com.daviddiazm.housing.category.domain.ports.out.HousePersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.HouseConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SaveHouseImp implements HouseService {

    private final HouseDtoMapper houseDtoMapper;
    private final HousePersistencePort housePersistencePort;

    @Override
    public SaveHouseResponse saveHouse(SaveHouseRequest saveHouseRequest) {
        housePersistencePort.saveHouse(houseDtoMapper.requestToModel(saveHouseRequest));
        return new SaveHouseResponse(HouseConstants.SAVE_CORRECTLY_MESSAGE, LocalDate.now());
    }
}
