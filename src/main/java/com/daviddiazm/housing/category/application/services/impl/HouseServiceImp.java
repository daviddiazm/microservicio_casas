package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.GetFilterHousePagedRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.HouseResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveHouseResponse;
import com.daviddiazm.housing.category.application.mappers.HouseDtoMapper;
import com.daviddiazm.housing.category.application.services.HouseService;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.ports.in.HouseServicePort;
import com.daviddiazm.housing.category.domain.utils.constants.HouseConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class
HouseServiceImp implements HouseService {

    private final HouseDtoMapper houseDtoMapper;
    private final HouseServicePort houseServicePort;

    @Override
    public SaveHouseResponse saveHouse(SaveHouseRequest saveHouseRequest) {
        houseServicePort.saveHouse(houseDtoMapper.requestToModel(saveHouseRequest));
        return new SaveHouseResponse(HouseConstants.SAVE_CORRECTLY_MESSAGE, LocalDate.now());
    }

    @Override
    public PagedResultResponse<HouseResponse> filterHousePaged(GetFilterHousePagedRequest request) {
        PagedResult<HouseModel> housesModel = houseServicePort.filterHousePaged(houseDtoMapper.requestFilterToModelFilter(request));
        List<HouseResponse> houses = houseDtoMapper.modelListToResponseList(housesModel.getContent());
        return new PagedResultResponse<>(
                houses,
                housesModel.getPage(),
                housesModel.getSize(),
                housesModel.isOrderAsc(),
                housesModel.getTotalElements(),
                housesModel.getTotalPages()
        );
    }
}
