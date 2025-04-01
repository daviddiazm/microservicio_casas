package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import com.daviddiazm.housing.category.domain.utils.constants.HouseConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationValidatorTest {
    
    @Test
    void validateSector_NullName_ThrowsIllegalArgumentException () {
        assertThrows(IllegalArgumentException.class, () -> LocationValidator.validateSector(null));
    }

    @Test
    void validateName_ShortName_ThrowsNameMinException() {
        assertThrows(NameMinException.class, () -> LocationValidator.validateSector("ab"));
    }

    @Test
    void validateSector_LongName_ThrowsNameMaxException() {
        String longName = "a".repeat(HouseConstants.MAX_NAME_CARACTER_LENGTH + 1);
        assertThrows(NameMaxException.class, () -> LocationValidator.validateSector(longName));
    }

    @Test
    void validateSector_ValidName_DoesNotThrowException() {
        assertDoesNotThrow(() -> LocationValidator.validateSector("Valid Name"));
    }
}