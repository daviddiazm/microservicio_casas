package com.daviddiazm.housing.category.application.mappers;

import com.daviddiazm.housing.category.application.dtos.requests.SaveLocationRequest;
import com.daviddiazm.housing.category.application.dtos.responses.LocationResponse;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDtoMapper {

    @Mapping(source = "municipalityId", target = "municipalityModel.id")
    LocationModel requestToModel (SaveLocationRequest saveLocationRequest);

    List<LocationModel> requestListToModelList(List<LocationResponse> locationsResponses);

    List<LocationResponse> modelListToRequestList(List<LocationModel> locationModels);
}
