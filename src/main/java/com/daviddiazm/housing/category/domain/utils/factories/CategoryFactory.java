package com.daviddiazm.housing.category.domain.utils.factories;

import com.daviddiazm.housing.category.domain.models.CategoryModel;

public class CategoryFactory {

    public static CategoryModel createCategory() {
        Long id = 1L;
        String name = "casa";
        String description = "esto es una casa";
        return new CategoryModel(id, name, description);
    }

    public static CategoryModel createCategory (Long id, String name, String description) {
        return new CategoryModel(id, name, description);
    }
}
