package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.MaxLengthException;
import com.daviddiazm.housing.category.domain.exceptions.MinLengthException;
import com.daviddiazm.housing.category.domain.utils.constants.GeneralConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralValidatorTest {

    @Test
    void validateStrings_validString_doesNotThrowException() {
        assertDoesNotThrow(() -> GeneralValidator.validateStrings("validString", 3, 15));
    }

    @Test
    void validateStrings_nullString_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GeneralValidator.validateStrings(null, 3, 15));
        assertEquals(GeneralConstants.FIELD_NAME_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void validateStrings_tooShortString_throwsMinLengthException() {
        MinLengthException exception = assertThrows(MinLengthException.class,
                () -> GeneralValidator.validateStrings("ab", 3, 15));
        assertEquals(GeneralConstants.NAME_MIN_LENGHT, exception.getMessage());
    }

    @Test
    void validateIntengers_validInteger_doesNotThrowException() {
        assertDoesNotThrow(() -> GeneralValidator.validateIntengers(5, 1, 10));
    }

    @Test
    void validateIntengers_tooSmallInteger_throwsMinLengthException() {
        MinLengthException exception = assertThrows(MinLengthException.class,
                () -> GeneralValidator.validateIntengers(0, 1, 10));
        assertEquals(GeneralConstants.NAME_MIN_LENGHT, exception.getMessage());
    }

    @Test
    void validateIntengers_tooLargeInteger_throwsMaxLengthException() {
        MaxLengthException exception = assertThrows(MaxLengthException.class,
                () -> GeneralValidator.validateIntengers(11, 1, 10));
        assertEquals(GeneralConstants.NAME_MAX_LENGHT, exception.getMessage());
    }

    @Test
    void validateDouble_validDouble_doesNotThrowException() {
        assertDoesNotThrow(() -> GeneralValidator.validateDouble(5.5, 1.0, 10.0));
    }

    @Test
    void validateDouble_tooSmallDouble_throwsMinLengthException() {
        MinLengthException exception = assertThrows(MinLengthException.class,
                () -> GeneralValidator.validateDouble(0.9, 1.0, 10.0));
        assertEquals(GeneralConstants.NAME_MIN_LENGHT, exception.getMessage());
    }

    @Test
    void validateDouble_tooLargeDouble_throwsMaxLengthException() {
        MaxLengthException exception = assertThrows(MaxLengthException.class,
                () -> GeneralValidator.validateDouble(10.1, 1.0, 10.0));
        assertEquals(GeneralConstants.NAME_MAX_LENGHT, exception.getMessage());
    }

    @Test
    void validateLongs_validLong_doesNotThrowException() {
        assertDoesNotThrow(() -> GeneralValidator.validateLongs(5L, 1L, 10L));
    }

    @Test
    void validateLongs_nullLong_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GeneralValidator.validateLongs(null, 1L, 10L));
        assertEquals(GeneralConstants.FIELD_NAME_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void validateLongs_tooSmallLong_throwsMinLengthException() {
        MinLengthException exception = assertThrows(MinLengthException.class,
                () -> GeneralValidator.validateLongs(0L, 1L, 10L));
        assertEquals(GeneralConstants.NAME_MIN_LENGHT, exception.getMessage());
    }

    @Test
    void validateLongs_tooLargeLong_throwsMaxLengthException() {
        MaxLengthException exception = assertThrows(MaxLengthException.class,
                () -> GeneralValidator.validateLongs(11L, 1L, 10L));
        assertEquals(GeneralConstants.NAME_MAX_LENGHT, exception.getMessage());
    }

    @Test
    void validateLongs_nullMinValue_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GeneralValidator.validateLongs(5L, null, 10L));
        assertEquals(GeneralConstants.FIELD_NAME_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void validateLongs_nullMaxValue_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> GeneralValidator.validateLongs(5L, 1L, null));
        assertEquals(GeneralConstants.FIELD_NAME_NULL_MESSAGE, exception.getMessage());
    }
}