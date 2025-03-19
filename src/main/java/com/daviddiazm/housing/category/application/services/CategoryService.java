package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;

import java.util.List;

public interface CategoryService {
    SaveCategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest);
    PagedResultResponse<CategoryResponse> getCategoriesPaginated(int page, int size, boolean orderAsc);

    List<CategoryResponse> getCategotiesByName(String categoryName);
}
