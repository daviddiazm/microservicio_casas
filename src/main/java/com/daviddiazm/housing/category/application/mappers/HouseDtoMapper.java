package com.daviddiazm.housing.category.application.mappers;

import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HouseDtoMapper {

    @Mapping(source = "categoryModel_id", target = "categoryModel.id")
    @Mapping(source = "locationModel_id", target = "locationModel.id")
    HouseModel requestToModel(SaveHouseRequest saveHouseRequest);
}
