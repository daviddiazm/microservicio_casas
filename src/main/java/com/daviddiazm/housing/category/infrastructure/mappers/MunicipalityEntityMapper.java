package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.infrastructure.entities.MunicipalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = DepartmentEntityMapper.class)
public interface MunicipalityEntityMapper {
    @Mapping(source = "departmentModel", target = "departmentEntity")
    MunicipalityEntity modelToEntity(MunicipalityModel municipalityModel);

    List<MunicipalityModel> entityListToModelList(List<MunicipalityEntity> municipalityEntityList);
}
