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

    @Mapping(source = "departmentEntity.id", target = "departmentModel.id")
    @Mapping(source = "departmentEntity.name", target = "departmentModel.name")
    @Mapping(source = "departmentEntity.description", target = "departmentModel.description")
    @Mapping(source = "departmentEntity.municipalities", target = "departmentModel.municipalities", ignore = true)
    MunicipalityModel entityToModel(MunicipalityEntity municipalityEntity);

    default List<MunicipalityModel> entityListToModelList(List<MunicipalityEntity> municipalityEntityList) {
        return municipalityEntityList.stream()
                .map(this::entityToModel)
                .toList();
    }
}