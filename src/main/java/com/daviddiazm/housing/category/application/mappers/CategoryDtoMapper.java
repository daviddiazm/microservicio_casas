package com.daviddiazm.housing.category.application.mappers;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
}
