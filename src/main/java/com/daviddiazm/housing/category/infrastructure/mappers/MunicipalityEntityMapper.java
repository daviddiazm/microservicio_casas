package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.infrastructure.entities.MunicipalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = DepartmentEntityMapper.class)
public interface MunicipalityEntityMapper {

    @Mapping(source = "departmentModel.id", target = "department.id")
    MunicipalityEntity modelToEntity(MunicipalityModel municipalityModel);

    @Mapping(target = "locations", ignore = true)
    @Mapping(source = "department.id", target = "departmentModel.id")
    @Mapping(source = "department.name", target = "departmentModel.name")
    @Mapping(source = "department.description", target = "departmentModel.description")
    @Mapping(target = "departmentModel.municipalities", ignore = true)
    MunicipalityModel entityToModel(MunicipalityEntity municipalityEntity);

    default List<MunicipalityModel> entityListToModelList(List<MunicipalityEntity> municipalityEntityList) {
        return municipalityEntityList.stream()
                .map(this::entityToModel)
                .toList();
    }
}