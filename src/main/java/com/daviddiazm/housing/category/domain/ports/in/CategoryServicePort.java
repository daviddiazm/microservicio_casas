package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.models.PaginationRequest;
import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;

public interface CategoryServicePort {
    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getCategoriesByName(String name);

    PagedResult<CategoryModel> getCategoriesPaginated(PaginationRequest paginationRequest);

}
