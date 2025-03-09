package com.daviddiazm.housing.category.application.services;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest saveCategoryRequest);
}
