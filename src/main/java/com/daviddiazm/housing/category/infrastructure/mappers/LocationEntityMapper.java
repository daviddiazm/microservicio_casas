package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MunicipalityEntityMapper.class)
public interface LocationEntityMapper {
    @Mapping(source = "municipalityModel.id", target = "municipalityEntity.id")
    LocationEntity modelToEntity(LocationModel locationModel);

    @Mapping(source = "municipalityEntity.id", target = "municipalityModel.id")
    @Mapping(source = "municipalityEntity.name", target = "municipalityModel.name")
    @Mapping(source = "municipalityEntity.description", target = "municipalityModel.description")
    @Mapping(source = "municipalityEntity.departmentEntity", target = "municipalityModel.departmentModel", ignore = true)
    @Mapping(source = "municipalityEntity.locations", target = "municipalityModel.locations", ignore = true)
    LocationModel entityToModel(LocationEntity locationEntity);

    default List<LocationModel> entityListToModelList(List<LocationEntity> locationEntityList) {
        return locationEntityList.stream()
                .map(this::entityToModel)
                .toList();
    }
}
