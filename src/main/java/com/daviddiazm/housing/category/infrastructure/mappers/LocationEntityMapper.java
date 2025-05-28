package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = MunicipalityEntityMapper.class)
public interface LocationEntityMapper {

    @Mapping(source = "municipalityModel.id", target = "municipality.id")
    LocationEntity modelToEntity(LocationModel locationModel);

    @Mapping(target = "houses", ignore = true)
    @Mapping(source = "municipality.id", target = "municipalityModel.id")
    @Mapping(source = "municipality.name", target = "municipalityModel.name")
    @Mapping(source = "municipality.description", target = "municipalityModel.description")
    @Mapping(source = "municipality.department.name", target = "municipalityModel.departmentModel.name")
    @Mapping(target = "municipalityModel.departmentModel.municipalities", ignore = true)
    @Mapping(source = "municipality.locations", target = "municipalityModel.locations", ignore = true)
    LocationModel entityToModel(LocationEntity locationEntity);

    default List<LocationModel> entityListToModelList(List<LocationEntity> locationEntityList) {
        return locationEntityList.stream()
                .map(this::entityToModel)
                .toList();
    }
}