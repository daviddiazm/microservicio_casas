package com.daviddiazm.housing.category.domain.utils.validations;

import com.daviddiazm.housing.category.domain.exceptions.*;
import com.daviddiazm.housing.category.domain.utils.constants.HouseConstants;

import java.time.LocalDate;

public class HouseValidator {
    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(HouseConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (name.length() < HouseConstants.MIN_NAME_CARACTER_LENGTH) {
            throw new NameMinException(HouseConstants.NAME_MIN_LENGHT);
        }
        if (name.length() > HouseConstants.MAX_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(HouseConstants.NAME_MAX_LENGHT);
        }
    }

    public static void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(HouseConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (description.length() < HouseConstants.MIN_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMinException(HouseConstants.DESCRIPTION_MIN_LENGHT);
        }
        if (description.length() > HouseConstants.MAX_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMaxException(HouseConstants.DESCRIPTION_MAX_LENGHT);
        }
    }

    public static void validateRooms(int roomsQuantity) {
        if (roomsQuantity == 0) {
            throw new IllegalArgumentException(HouseConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (roomsQuantity > HouseConstants.MAX_ROOMS_CARACTER_LENGTH) {
            throw new DescriptionMinException(HouseConstants.DESCRIPTION_MIN_LENGHT);
        }
    }

    public static void validateBathRooms(int roomsQuantity) {
        if (roomsQuantity == 0) {
            throw new IllegalArgumentException(HouseConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (roomsQuantity > HouseConstants.MAX_ROOMS_CARACTER_LENGTH) {
            throw new DescriptionMinException(HouseConstants.DESCRIPTION_MIN_LENGHT);
        }
    }

    public static void validateAdress(String adress) {
        if (adress == null) {
            throw new IllegalArgumentException(HouseConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (adress.length() < HouseConstants.MIN_ADRESS_CARACTER_LENGTH) {
            throw new DescriptionMinException(HouseConstants.ADRESS_MIN_LENGHT);
        }
        if (adress.length() > HouseConstants.MAX_ADRESS_CARACTER_LENGTH) {
            throw new DescriptionMaxException(HouseConstants.ADRESS_MAX_LENGHT);
        }
    }

    public static void validatePublishDate(LocalDate publishDate) {
        LocalDate todayDate = LocalDate.now();

        if (publishDate == null) {
            throw new IllegalArgumentException(HouseConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if(publishDate.isAfter(todayDate.plusMonths(1))) {
            throw new PublishDateExceedsException(HouseConstants.PUBLISH_DATE_EXCEES);
        }
    }

}
