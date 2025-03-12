package com.daviddiazm.housing.category.domain.utils.validations;

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
        // Arrange
        String shortName = "ab";

        // Act & Assert
        assertThrows(NameMinException.class, () -> CategoryValidator.validateName(shortName));
    }

    @Test
    void validateName_ShouldThrowNameMaxException_WhenNameIsTooLong() {
        // Arrange
        String longName = "a".repeat(51); // Nombre de 51 caracteres

        // Act & Assert
        assertThrows(NameMaxException.class, () -> CategoryValidator.validateName(longName));
    }

    @Test
    void validateDescription_ShouldNotThrowException_WhenDescriptionIsValid() {
        // Arrange
        String validDescription = "This is a valid description.";

        // Act & Assert
        assertDoesNotThrow(() -> CategoryValidator.validateDescription(validDescription));
    }

}