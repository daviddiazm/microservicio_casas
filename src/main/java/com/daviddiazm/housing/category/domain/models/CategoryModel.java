package com.daviddiazm.housing.category.domain.models;

import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;
import com.daviddiazm.housing.category.domain.utils.validations.CategoryValidator;

import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CategoryValidator.validateName(name);
        this.name = Objects.requireNonNull(name,DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        CategoryValidator.validateDescription(description);
        this.description = Objects.requireNonNull(description,DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }
}
