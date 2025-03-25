package com.daviddiazm.housing.category.domain.ports.out;

import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List<CategoryModel> getCategoriesByName(String categoryName);
    PagedResult<CategoryModel> getCategoriesPaginated(int page, int size, boolean orderAsc);
}
