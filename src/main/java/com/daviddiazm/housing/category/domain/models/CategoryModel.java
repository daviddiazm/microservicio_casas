package com.daviddiazm.housing.category.domain.models;

import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;
import com.daviddiazm.housing.category.domain.utils.validations.CategoryValidator;

import java.util.List;
import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;
    private List<HouseModel> houses;

    public CategoryModel() {
    }

    public CategoryModel(Long id, String name, String description, List<HouseModel> houses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.houses = houses;
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

    public List<HouseModel> getHouses() {
        return houses;
    }

    public void setHouses(List<HouseModel> houses) {
        this.houses = houses;
    }
}
