package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.dtos.requests.PaginationRequest;
import com.daviddiazm.housing.category.domain.exceptions.*;
import com.daviddiazm.housing.category.domain.models.CategoryFactory;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void saveCategory_WhenNameExist_TrhowNameAlreadyExist () {
        String categoryName = "casa";
        CategoryModel category = CategoryFactory.createCategory();

        when(categoryPersistencePort.getCategoryByName(categoryName)).thenReturn(category);

        assertThrows(NameAlreadyExist.class, () -> categoryUseCase.saveCategory(category));

    }

    @Test
    void getCategoriesByName_WhenListIsEmpy_Expect_ThrowCategoryDontExist() {
        String categoryName = "casa";
        when(categoryPersistencePort.getCategoriesByName(categoryName)).thenReturn(List.of());

        assertThrows(CategoryNotExist.class, () -> categoryUseCase.getCategoriesByName(categoryName));
    }

    @Test
    void getCategoriesByName_WhenNameTooShort_ThrowsDescriptionMinException() {
        String shortName = "ab";
        CategoryModel category = CategoryFactory.createCategory();

        List<CategoryModel> mockList = List.of(category);

        when(categoryPersistencePort.getCategoriesByName(shortName)).thenReturn(mockList);

        assertThrows(DescriptionMinException.class, () -> categoryUseCase.getCategoriesByName(shortName));
    }

    @Test
    void getCategoriesByName_WhenNameTooLong_ThrowsDescriptionMaxException() {
        String longName = "a".repeat(51);
        CategoryModel category = CategoryFactory.createCategory();
        List<CategoryModel> mockList = List.of(category);

        when(categoryPersistencePort.getCategoriesByName(longName)).thenReturn(mockList);

        assertThrows(DescriptionMaxException.class, () -> categoryUseCase.getCategoriesByName(longName));
    }

    @Test
    void getCategoriesByName_WhenValidName_ReturnsList() {
        String validName = "casa";
        CategoryModel category = CategoryFactory.createCategory();
        String name = "casa duplex";
        String description = "es una casa duplex";
        CategoryModel category2 = CategoryFactory.createCategory(2L, name, description);

        List<CategoryModel> expectedList = List.of(category, category2);

        when(categoryPersistencePort.getCategoriesByName(validName)).thenReturn(expectedList);

        List<CategoryModel> result = categoryUseCase.getCategoriesByName(validName);

        assertEquals(expectedList, result);
        verify(categoryPersistencePort).getCategoriesByName(validName);
    }

    @Test
    void getCategoriesPaginated_DelegatesToPersistencePort() {
        CategoryModel category = CategoryFactory.createCategory();
        String name = "casa duplex";
        String description = "es una casa duplex";
        CategoryModel category2 = CategoryFactory.createCategory(2L, name, description);
        PaginationRequest request = new PaginationRequest(0, 10, true);
        List<CategoryModel> expectedList = List.of(category, category2);

        when(categoryPersistencePort.getCategoriesPaginated(request)).thenReturn(expectedList);

        List<CategoryModel> result = categoryUseCase.getCategoriesPaginated(request);

        assertEquals(expectedList, result);
        verify(categoryPersistencePort).getCategoriesPaginated(request);
    }
}