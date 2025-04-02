package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveHouseResponse;
import com.daviddiazm.housing.category.application.mappers.HouseDtoMapper;
import com.daviddiazm.housing.category.application.services.HouseService;
import com.daviddiazm.housing.category.domain.ports.in.HouseServicePort;
import com.daviddiazm.housing.category.domain.utils.constants.HouseConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class HouseServiceImp implements HouseService {

    private final HouseDtoMapper houseDtoMapper;
    private final HouseServicePort houseServicePort;

    @Override
    public SaveHouseResponse saveHouse(SaveHouseRequest saveHouseRequest) {
        houseServicePort.saveHouse(houseDtoMapper.requestToModel(saveHouseRequest));
        return new SaveHouseResponse(HouseConstants.SAVE_CORRECTLY_MESSAGE, LocalDate.now());
    }
}
