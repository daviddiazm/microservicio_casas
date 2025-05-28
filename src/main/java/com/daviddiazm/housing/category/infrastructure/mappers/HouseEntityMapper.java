package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.infrastructure.entities.HouseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CategoryEntityMapper.class, LocationEntityMapper.class})
public interface HouseEntityMapper {

    @Mapping(source = "category", target = "category")
    @Mapping(source = "location", target = "location")
    HouseEntity modelToEntity(HouseModel houseModel);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "location", target = "location")
    List<HouseEntity> listModelToListEntity(List<HouseModel> houseModels);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "location", target = "location")
    List<HouseModel> listEntityToListModel(List<HouseEntity> houseEntities);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "location", target = "location")
    HouseModel entityToModel(HouseEntity houseEntity);
}