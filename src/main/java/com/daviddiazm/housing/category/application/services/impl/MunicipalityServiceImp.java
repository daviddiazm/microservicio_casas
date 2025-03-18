package com.daviddiazm.housing.category.application.services.impl;
import com.daviddiazm.housing.category.application.dtos.requests.SaveMunicipalityRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveMunicipalityResponse;
import com.daviddiazm.housing.category.application.mappers.MunicipalityDtoMapper;
import com.daviddiazm.housing.category.application.services.MunicipalityService;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;
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
    private final DepartmentPersistencePort departmentPersistencePort;

    @Override
    public SaveMunicipalityResponse saveMunicipality(SaveMunicipalityRequest saveMunicipalityRequest) {
        System.out.println("service municipal impl");
        System.out.println(saveMunicipalityRequest);
        DepartmentModel departmet = departmentPersistencePort.getDepartmentById(saveMunicipalityRequest.departmentId());

        municipalityServicePort.saveMunicipality(
                new MunicipalityModel(
                        null,
                        saveMunicipalityRequest.name(),
                        saveMunicipalityRequest.description(),
                        departmet
                )
        );
        return new SaveMunicipalityResponse(MunicipalityConstants.SAVE_CORRECTLY_MESSAGE, LocalDateTime.now());
    }
}
