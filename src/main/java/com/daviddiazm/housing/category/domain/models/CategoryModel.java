package com.daviddiazm.housing.category.domain.models;

import com.daviddiazm.housing.category.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.housing.category.domain.exceptions.DescriptionMinException;
import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;

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
        if(name.length() < 3 ) {
            throw new NameMinException("Numero minimo de caracteres es 3");
        }
        if(name.length() > 50 ) {
            throw new NameMaxException("Numero Maximo de caracteres es 50");
        }
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.length() < 10) {
            throw new DescriptionMinException("Numero minimo de caracteres es 10");
        }
        if(description.length() > 90) {
            throw new DescriptionMaxException("Numero maximo de caracteres es 90");
        }
        this.description = Objects.requireNonNull(description,DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }
}
