package com.daviddiazm.housing.category.domain.utils.factories;

import com.daviddiazm.housing.category.domain.models.CategoryModel;

import java.util.List;

public class CategoryFactory {

    public static CategoryModel createCategory() {
        Long id = 1L;
        String name = "casa";
        String description = "esto es una casa";
        return new CategoryModel(id, name, description, List.of());
    }

    public static CategoryModel createCategory (Long id, String name, String description) {
        return new CategoryModel(id, name, description, List.of());
    }
}
