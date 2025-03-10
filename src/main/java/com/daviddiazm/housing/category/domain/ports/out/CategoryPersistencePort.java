package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.dtos.requests.PaginationRequest;
import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;

public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List<CategoryModel> getCategoriesByName(String categoryName);
    List<CategoryModel> getCategoriesPaginated(PaginationRequest paginationRequest);
    List<CategoryModel> getAllCategories ();
}
