package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.CategoryNotExist;
import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExist;
import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import com.daviddiazm.housing.category.domain.exceptions.NameMinException;
import com.daviddiazm.housing.category.domain.models.CategoryFactory;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    CategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    CategoryUseCase categoryUseCase;

    @Test
    void saveCategory_WhenNameExists_ThrowsNameAlreadyExist() {
        String categoryName = "ExistingCategory";
        CategoryModel existingCategory = CategoryFactory.createCategory();
        existingCategory.setName(categoryName);

        when(categoryPersistencePort.getCategoryByName(categoryName)).thenReturn(existingCategory);

        CategoryModel newCategory = CategoryFactory.createCategory();
        newCategory.setName(categoryName);

        assertThrows(NameAlreadyExist.class, () -> categoryUseCase.saveCategory(newCategory));

    }

    @Test
    void saveCategory_WhenNameDoesNotExist_SavesSuccesfully () {
        CategoryModel category = CategoryFactory.createCategory();

        when(categoryPersistencePort.getCategoryByName(category.getName())).thenReturn(null);

        categoryUseCase.saveCategory(category);

        verify(categoryPersistencePort).saveCategory(category);
    }

    @Test
    void getCategoriesByName_WhenListIsEmpy_Expect_ThrowCategoryDontExist() {
        String categoryName = "casa";
        when(categoryPersistencePort.getCategoriesByName(categoryName)).thenReturn(List.of());

        assertThrows(CategoryNotExist.class, () -> categoryUseCase.getCategoriesByName(categoryName));
    }


}