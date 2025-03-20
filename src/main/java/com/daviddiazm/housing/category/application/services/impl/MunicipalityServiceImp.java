package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.GetMunicipalitiesPagedRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveMunicipalityRequest;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveMunicipalityResponse;
import com.daviddiazm.housing.category.application.mappers.MunicipalityDtoMapper;
import com.daviddiazm.housing.category.application.services.MunicipalityService;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.ports.in.MunicipalityServicePort;
import com.daviddiazm.housing.category.domain.ports.out.DepartmentPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.MunicipalityConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MunicipalityServiceImp implements MunicipalityService {

    private final MunicipalityDtoMapper municipalityDtoMapper;
    private final MunicipalityServicePort municipalityServicePort;


    @Override
    public SaveMunicipalityResponse saveMunicipality(SaveMunicipalityRequest saveMunicipalityRequest) {
        municipalityServicePort.saveMunicipality(municipalityDtoMapper.
                requestToModel(saveMunicipalityRequest));
        return new SaveMunicipalityResponse(MunicipalityConstants.SAVE_CORRECTLY_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PagedResultResponse<MunicipalityModel> getMunicipalitiesPaginated(GetMunicipalitiesPagedRequest request) {
        int page = request.page();
        int size = request.size();
        boolean orderAc = request.orderAsc();
        String name = request.name();
        return municipalityDtoMapper.toPagedResultResponse(municipalityServicePort.getMunicipalitiesPaginated(page, size, orderAc, name));
    }
}
