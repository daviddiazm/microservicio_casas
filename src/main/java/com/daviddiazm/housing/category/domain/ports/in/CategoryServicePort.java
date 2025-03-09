package com.daviddiazm.housing.category.domain.ports.in;

import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;

public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
    List<CategoryModel> getAllCategories();
}
