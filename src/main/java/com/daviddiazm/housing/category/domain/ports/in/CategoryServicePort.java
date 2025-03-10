package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.dtos.requests.PaginationRequest;
import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;

public interface CategoryServicePort {
    void save(CategoryModel categoryModel);

    List<CategoryModel> getCategoriesByName(String name);

    List<CategoryModel> getCategoriesPaginated(PaginationRequest paginationRequest);

    List<CategoryModel> getAllCategories();
}
