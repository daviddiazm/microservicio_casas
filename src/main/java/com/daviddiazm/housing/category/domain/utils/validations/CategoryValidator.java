package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.housing.category.domain.exceptions.DescriptionMinException;
import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;

public class CategoryValidator {
    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(DomainConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (name.length() < DomainConstants.MIN_NAME_CARACTER_LENGTH) {
            throw new NameMinException(DomainConstants.DESCRIPTION_MIN_LENGHT);
        }
        if (name.length() > DomainConstants.MAX_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(DomainConstants.DESCRIPTION_MAX_LENGHT);
        }
    }

    public static void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (description.length() < DomainConstants.MIN_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMinException(DomainConstants.DESCRIPTION_MIN_LENGHT);
        }
        if (description.length() > DomainConstants.MAX_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMaxException(DomainConstants.DESCRIPTION_MAX_LENGHT);
        }
    }
}
