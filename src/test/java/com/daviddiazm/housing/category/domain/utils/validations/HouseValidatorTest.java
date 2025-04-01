package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.*;
import com.daviddiazm.housing.category.domain.utils.constants.HouseConstants;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HouseValidatorTest {

    @Test
    void validateName_NullName_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HouseValidator.validateName(null));
    }

    @Test
    void validateName_ShortName_ThrowsNameMinException() {
        assertThrows(NameMinException.class, () -> HouseValidator.validateName("ab"));
    }

    @Test
    void validateName_LongName_ThrowsNameMaxException() {
        String longName = "a".repeat(HouseConstants.MAX_NAME_CARACTER_LENGTH + 1);
        assertThrows(NameMaxException.class, () -> HouseValidator.validateName(longName));
    }

    @Test
    void validateName_ValidName_DoesNotThrowException() {
        assertDoesNotThrow(() -> HouseValidator.validateName("Valid Name"));
    }

    @Test
    void validateDescription_NullDescription_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HouseValidator.validateDescription(null));
    }

    @Test
    void validateDescription_ShortDescription_ThrowsDescriptionMinException() {
        assertThrows(DescriptionMinException.class, () -> HouseValidator.validateDescription("short"));
    }

    @Test
    void validateDescription_LongDescription_ThrowsDescriptionMaxException() {
        String longDescription = "a".repeat(HouseConstants.MAX_DESCRIPTION_CARACTER_LENGTH + 1);
        assertThrows(DescriptionMaxException.class, () -> HouseValidator.validateDescription(longDescription));
    }

    @Test
    void validateDescription_ValidDescription_DoesNotThrowException() {
        assertDoesNotThrow(() -> HouseValidator.validateDescription("Valid description"));
    }

    @Test
    void validateRooms_ZeroRooms_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HouseValidator.validateRooms(0));
    }

    @Test
    void validateRooms_TooManyRooms_ThrowsDescriptionMinException() {
        assertThrows(DescriptionMinException.class, () -> HouseValidator.validateRooms(HouseConstants.MAX_ROOMS_CARACTER_LENGTH + 1));
    }

    @Test
    void validateRooms_ValidRooms_DoesNotThrowException() {
        assertDoesNotThrow(() -> HouseValidator.validateRooms(5));
    }

    @Test
    void validateBathRooms_ZeroBathRooms_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HouseValidator.validateBathRooms(0));
    }

    @Test
    void validateBathRooms_TooManyBathRooms_ThrowsDescriptionMinException() {
        assertThrows(DescriptionMinException.class, () -> HouseValidator.validateBathRooms(HouseConstants.MAX_ROOMS_CARACTER_LENGTH + 1));
    }

    @Test
    void validateBathRooms_ValidBathRooms_DoesNotThrowException() {
        assertDoesNotThrow(() -> HouseValidator.validateBathRooms(2));
    }

    @Test
    void validateAdrees_NullAdress_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HouseValidator.validateAdress(null));
    }

    @Test
    void validateAdrees_ShortAdress_ThrowsDescriptionMinException() {
        assertThrows(DescriptionMinException.class, () -> HouseValidator.validateAdress("aaa"));
    }

    @Test
    void validateAdrees_LongAdress_ThrowsDescriptionMaxException() {
        String longAdress = "a".repeat(HouseConstants.MAX_ADRESS_CARACTER_LENGTH + 1);
        assertThrows(DescriptionMaxException.class, () -> HouseValidator.validateAdress(longAdress));
    }

    @Test
    void validateAdrees_ValidAdress_DoesNotThrowException() {
        assertDoesNotThrow(() -> HouseValidator.validateAdress("Valid Address"));
    }

    @Test
    void validatePublishDate_NullPublishDate_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HouseValidator.validatePublishDate(null));
    }

    @Test
    void validatePublishDate_FutureDateExceedsLimit_ThrowsPublishDateExceedsException() {
        LocalDate futureDate = LocalDate.now().plusMonths(2);
        assertThrows(PublishDateExceedsException.class, () -> HouseValidator.validatePublishDate(futureDate));
    }

    @Test
    void validatePublishDate_ValidPublishDate_DoesNotThrowException() {
        LocalDate validDate = LocalDate.now().plusWeeks(1);
        assertDoesNotThrow(() -> HouseValidator.validatePublishDate(validDate));
    }

}