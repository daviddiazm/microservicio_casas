package com.daviddiazm.housing.category.infrastructure.mappers;


import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);

    @Mapping(target = "houses", ignore = true)
    CategoryModel entityCategoryToCategoryModel (CategoryEntity categoryEntity);

    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
