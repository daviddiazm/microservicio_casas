package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import com.daviddiazm.housing.category.domain.utils.constants.LocationConstants;

public class LocationValidator {
    public static void validateSector(String sector) {
        if (sector == null) {
            throw new IllegalArgumentException(LocationConstants.SECTOR_NULL_MESSAGE);
        }
        if (sector.length() < LocationConstants.MIN_SECTOR_CARACTER_LENGTH) {
            throw new NameMinException(LocationConstants.SECTOR_MIN_LENGHT);
        }
        if (sector.length() > LocationConstants.MAX_SECTOR_CARACTER_LENGTH) {
            throw new NameMaxException(LocationConstants.SECTOR_MAX_LENGHT);
        }
    }
}
