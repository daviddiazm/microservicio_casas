package com.daviddiazm.housing.category.application.mappers;

import com.daviddiazm.housing.category.application.dtos.requests.GetPaginationRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.domain.dtos.requests.PaginationRequest;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
    List<CategoryResponse> modelListToResponseList(List<CategoryModel> categories);
    PaginationRequest toPaginationRequest(GetPaginationRequest getPaginationRequest);
}


