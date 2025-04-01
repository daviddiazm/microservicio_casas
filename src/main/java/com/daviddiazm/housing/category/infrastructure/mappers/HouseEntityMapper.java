package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.infrastructure.entities.HouseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HouseEntityMapper {
    @Mapping(source = "categoryModel.id", target = "categoryEntity.id")
    @Mapping(source = "locationModel.id", target = "locationEntity.id")
    HouseEntity modelToEntity(HouseModel houseModel);
}
