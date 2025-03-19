package com.daviddiazm.housing.category.application.mappers;

import com.daviddiazm.housing.category.application.dtos.requests.SaveMunicipalityRequest;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MunicipalityDtoMapper {
    @Mapping(source = "departmentId", target = "departmentModel.id")
    MunicipalityModel requestToModel(SaveMunicipalityRequest saveMunicipalityRequest);
}
