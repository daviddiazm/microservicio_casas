package com.daviddiazm.housing.category.application.mappers;

import com.daviddiazm.housing.category.application.dtos.requests.GetFilterHouseByCityNameRequest;
import com.daviddiazm.housing.category.application.dtos.requests.GetFilterHousePagedRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.HouseResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.domain.models.FilterHouseByCityNameParams;
import com.daviddiazm.housing.category.domain.models.FilterHouseParameters;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HouseDtoMapper {

    @Mapping(source = "categoryModel_id", target = "category.id")
    @Mapping(source = "locationModel_id", target = "location.id")
    HouseModel requestToModel(SaveHouseRequest saveHouseRequest);

    FilterHouseParameters requestFilterToModelFilter(GetFilterHousePagedRequest request);
    FilterHouseByCityNameParams requestToModelFilter (GetFilterHouseByCityNameRequest request);

    List<HouseResponse> modelListToResponseList (List<HouseModel> houseModels);
}
