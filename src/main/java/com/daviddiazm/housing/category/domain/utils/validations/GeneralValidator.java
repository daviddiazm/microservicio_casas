package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.MaxLengthException;
import com.daviddiazm.housing.category.domain.exceptions.MinLengthException;
import com.daviddiazm.housing.category.domain.utils.constants.GeneralConstants;
import com.daviddiazm.housing.category.domain.utils.constants.MunicipalityConstants;

public class GeneralValidator {
    public static void validateStrings(String value, int minLength, int maxLength) {
        if (value == null) {
            throw new IllegalArgumentException(GeneralConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (value.length() < minLength) {
            throw new MinLengthException(GeneralConstants.NAME_MIN_LENGHT);
        }
        if (value.length() > maxLength) {
            throw new MaxLengthException(GeneralConstants.NAME_MAX_LENGHT);
        }
    }
    public static void validateIntengers(int value, int minValue, int maxValue) {
        if (value < minValue) {
            throw new MinLengthException(GeneralConstants.NAME_MIN_LENGHT);
        }
        if (value > maxValue) {
            throw new MaxLengthException(GeneralConstants.NAME_MAX_LENGHT);
        }
    }
    public static void validateDouble(double value, double minValue, double maxValue) {
        if (value < minValue) {
            throw new MinLengthException(GeneralConstants.NAME_MIN_LENGHT);
        }
        if (value > maxValue) {
            throw new MaxLengthException(GeneralConstants.NAME_MAX_LENGHT);
        }
    }

    public static void validateLongs(Long value, Long minValue, Long maxValue) {
        if (value == null || minValue == null || maxValue == null) {
            throw new IllegalArgumentException(GeneralConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (value < minValue) {
            throw new MinLengthException(GeneralConstants.NAME_MIN_LENGHT);
        }
        if (value > maxValue) {
            throw new MaxLengthException(GeneralConstants.NAME_MAX_LENGHT);
        }
    }
}
