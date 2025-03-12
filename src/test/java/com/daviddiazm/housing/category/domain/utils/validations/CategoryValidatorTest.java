package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.housing.category.domain.exceptions.DescriptionMinException;
import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryValidatorTest {

    @Test
    void validateName_ShouldNotThrowException_WhenNameIsValid() {
        String validName = "Valid Name";

        assertDoesNotThrow(() -> CategoryValidator.validateName(validName));
    }

    @Test
    void validateName_ShouldThrowNameMinException_WhenNameIsTooShort() {
        String shortName = "ab";

        assertThrows(NameMinException.class, () -> CategoryValidator.validateName(shortName));
    }

    @Test
    void validateName_ShouldThrowNameMaxException_WhenNameIsTooLong() {

        String longName = "a".repeat(51);

        assertThrows(NameMaxException.class, () -> CategoryValidator.validateName(longName));
    }

    @Test
    void validateName_When_ValueIsNull_TrhowIllegalArgumentException () {

        assertThrows(IllegalArgumentException.class,() -> CategoryValidator.validateName(null));
    }

//    description
    @Test
    void validateDescription_ShouldNotThrowException_WhenDescriptionIsValid() {
        String validDescription = "This is a valid description.";

        assertDoesNotThrow(() -> CategoryValidator.validateDescription(validDescription));
    }

    @Test
    void validateDescription_ShouldThrowDescriptionMaxException_WhenDescriptionIsTooLong() {

        String longDescription = "a".repeat(91);

        assertThrows(DescriptionMaxException.class, () -> CategoryValidator.validateDescription(longDescription));
    }

    @Test
    void validateDescription_ShouldThrowDescriptionMinException_WhenDescriptionIsTooShort() {

        String shortDescription = "a".repeat(8);

        assertThrows(DescriptionMinException.class, () -> CategoryValidator.validateDescription(shortDescription));
    }

    @Test
    void validateDescription_When_ValueIsNull_TrhowIllegalArgumentException () {

        assertThrows(IllegalArgumentException.class,() -> CategoryValidator.validateDescription(null));
    }

}