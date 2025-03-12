package com.daviddiazm.housing.category.domain.models;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CategoryModelTest {

    @Test
    void when_GetId_Expected_ValueExpected() {
        CategoryModel category = CategoryFactory.createCategory();
        Long expected = 1L ;

        assertEquals(expected, category.getId());
    }

    @Test
    void setId_ShouldNotThrowAnyException() {
        CategoryModel category = CategoryFactory.createCategory();

        assertDoesNotThrow(() -> category.setId(2L));
    }

    @Test
    void when_GetName_Expected_ValueExpected() {
        CategoryModel category = CategoryFactory.createCategory();
        String expected = "casa";

        assertEquals(expected, category.getName());
    }

    @Test
    void setName_ShouldNotThrowException_WhenNameIsValid() {
        CategoryModel category = CategoryFactory.createCategory();

        assertDoesNotThrow(() -> category.setName("Un nombre valido"));
    }


    @Test
    void should_ReturnCategoryDescription() {
        CategoryModel category = CategoryFactory.createCategory();
        String expected = "esto es una casa";

        assertEquals(expected, category.getDescription());
    }

    @Test
    void setDescription_ShoudlNotThrowException_WhenDescriptionIsValid() {
        CategoryModel category = CategoryFactory.createCategory();

        assertDoesNotThrow(() -> category.setDescription("Una descripcion valida"));
    }
}