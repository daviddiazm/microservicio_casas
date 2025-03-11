package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.requests.GetPaginationRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.mappers.CategoryDtoMapper;
import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImpTest {

    @Mock
    private CategoryDtoMapper categoryDtoMapper;

    @Mock
    private CategoryServicePort categoryServicePort;

    @InjectMocks
    private CategoryServiceImp categoryServiceImp;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void When_CategoryInformationIsCorrect_Expect_CategorySaveResponseMassege() {
//        datos
        String categoryName = "casa";
        String categoryDescription = "tiene cuatro paredes";
        SaveCategoryRequest request = new SaveCategoryRequest(categoryName, categoryDescription);
        String textExpected = "Category created successfully.";
//        ejecucion
        SaveCategoryResponse response = categoryServiceImp.save(request);
//        verificacion
        assertEquals(textExpected, response.message());

    }

    @Test
    void When_PaginatedInformationIsCorrtect_Expect_CategoryResponseList() {
        int page = 0;
        int size = 1;
        boolean orderAsc = true;
        GetPaginationRequest request = new GetPaginationRequest(page, size, orderAsc);

        List<CategoryResponse> response = categoryServiceImp.getCategoriesPaginated(request);

        assertEquals(true, response.isEmpty());
    }
}