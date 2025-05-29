package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.MinLengthException;
import com.daviddiazm.housing.category.domain.models.FilterHouseByCityNameParams;
import com.daviddiazm.housing.category.domain.models.FilterHouseParameters;
import com.daviddiazm.housing.category.domain.utils.constants.GeneralConstants;

public class FilterHouseByCityNameValidator {
    public static void validate(FilterHouseByCityNameParams parameters) {
        GeneralValidator.validateLongs(parameters.getIdCategory(), 0L, 9999999L);
        GeneralValidator.validateIntengers(parameters.getRoomsQuantity(), 0, 99999);
        GeneralValidator.validateIntengers(parameters.getBathroomsQuantity(), 0, 99999);
        GeneralValidator.validateIntengers(parameters.getBathroomsQuantity(), 0, 99999);
        if (parameters.getMinPrice() > parameters.getMaxPrice()){
            throw new MinLengthException(GeneralConstants.NAME_MIN_LENGHT);
        }
        GeneralValidator.validateDouble(parameters.getMinPrice(), 0, 9999999);
        GeneralValidator.validateDouble(parameters.getMaxPrice(), 0, 9999999);
    }
}
