package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.housing.category.domain.exceptions.DescriptionMinException;
import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import com.daviddiazm.housing.category.domain.utils.constants.MunicipalityConstants;

public class MunicipalityValidator {
    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(MunicipalityConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (name.length() < MunicipalityConstants.MIN_NAME_CARACTER_LENGTH) {
            throw new NameMinException(MunicipalityConstants.NAME_MIN_LENGHT);
        }
        if (name.length() > MunicipalityConstants.MAX_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(MunicipalityConstants.NAME_MAX_LENGHT);
        }
    }

    public static void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(MunicipalityConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (description.length() < MunicipalityConstants.MIN_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMinException(MunicipalityConstants.DESCRIPTION_MIN_LENGHT);
        }
        if (description.length() > MunicipalityConstants.MAX_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMaxException(MunicipalityConstants.DESCRIPTION_MAX_LENGHT);
        }
    }
}
