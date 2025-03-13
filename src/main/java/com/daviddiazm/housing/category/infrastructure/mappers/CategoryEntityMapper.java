package com.daviddiazm.housing.category.infrastructure.mappers;


import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
