package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.housing.category.domain.exceptions.DescriptionMinException;
import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import com.daviddiazm.housing.category.domain.utils.constants.DepartmentConstants;

public class DepartmentValidator {
    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(DepartmentConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (name.length() < DepartmentConstants.MIN_NAME_CARACTER_LENGTH) {
            throw new NameMinException(DepartmentConstants.NAME_MIN_LENGHT);
        }
        if (name.length() > DepartmentConstants.MAX_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(DepartmentConstants.NAME_MAX_LENGHT);
        }
    }

    public static void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(DepartmentConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (description.length() < DepartmentConstants.MIN_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMinException(DepartmentConstants.DESCRIPTION_MIN_LENGHT);
        }
        if (description.length() > DepartmentConstants.MAX_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMaxException(DepartmentConstants.DESCRIPTION_MAX_LENGHT);
        }
    }
}
