package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.dtos.requests.PaginationRequest;
import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;

public interface CategoryServicePort {
    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getCategoriesByName(String name);

    List<CategoryModel> getCategoriesPaginated(PaginationRequest paginationRequest);

}
