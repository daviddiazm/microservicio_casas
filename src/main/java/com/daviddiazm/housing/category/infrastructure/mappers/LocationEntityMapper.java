package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MunicipalityEntityMapper.class)
public interface LocationEntityMapper {
    @Mapping(source = "municipalityModel.id", target = "municipalityEntity.id")
    LocationEntity modelToEntity(LocationModel locationModel);
}
