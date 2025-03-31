package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.infrastructure.entities.MunicipalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MunicipalityEntityMapper {
    @Mapping(source = "departmentModel.id", target = "departmentEntity.id")
    MunicipalityEntity modelToEntity(MunicipalityModel municipalityModel);

    @Mapping(source = "departmentModel.id", target = "departmentEntity.id")
    List<MunicipalityModel> entityListToModelList (List<MunicipalityEntity> municipalityEntityList);
}
