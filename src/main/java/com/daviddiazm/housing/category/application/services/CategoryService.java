package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.GetPaginationRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;

import java.util.List;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest saveCategoryRequest);
    List<CategoryResponse> getCategoriesPaginated(GetPaginationRequest paginationRequest);
}
