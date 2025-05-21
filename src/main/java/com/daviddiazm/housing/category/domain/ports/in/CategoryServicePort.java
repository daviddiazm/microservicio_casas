package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface CategoryServicePort {
    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getCategoriesByName(String name);

    PagedResult<CategoryModel> getCategoriesPaginated(int page, int size, boolean orderAsc);

    CategoryModel getCategoryByName(String name);
}
