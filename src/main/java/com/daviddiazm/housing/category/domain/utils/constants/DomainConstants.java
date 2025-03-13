package com.daviddiazm.housing.category.domain.utils.constants;

public class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utily class");
    }

    public static final int MIN_NAME_CARACTER_LENGTH = 3;
    public static final int MAX_NAME_CARACTER_LENGTH = 50;

    public static final int MIN_DESCRIPTION_CARACTER_LENGTH = 10;
    public static final int MAX_DESCRIPTION_CARACTER_LENGTH = 90;


    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can not be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can not be null";

    public static final String DESCRIPTION_MIN_LENGHT = "The min length for description needs most to be ten caracters";
    public static final String DESCRIPTION_MAX_LENGHT = "The max length for description needs most to be 50 caracters";

    public static final String NAME_ALREADY_EXIST = "The name is already exist";
    public static final String CATEGORY_NO_EXIST = "The category not exist";

}
