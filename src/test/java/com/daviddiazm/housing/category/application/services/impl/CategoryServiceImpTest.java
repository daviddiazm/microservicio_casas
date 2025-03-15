package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.mappers.CategoryDtoMapper;
import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class CategoryServiceImpTest {

    @Mock
    private CategoryDtoMapper categoryDtoMapper;

    @Mock
    private CategoryServicePort categoryServicePort;

    @InjectMocks
    private CategoryServiceImp categoryServiceImp;


    @Test
    void When_CategoryInformationIsCorrect_Expect_CategorySaveResponseMassege() {
//        datos
        String categoryName = "casa";
        String categoryDescription = "tiene cuatro paredes";
        SaveCategoryRequest request = new SaveCategoryRequest(categoryName, categoryDescription);
        String textExpected = "Category created successfully.";
//        ejecucion
        SaveCategoryResponse response = categoryServiceImp.saveCategory(request);
//        verificacion
        assertEquals(textExpected, response.message());

    }

//    @Test
//    void When_PaginatedInformationIsCorrtect_Expect_CategoryResponseList() {
//        int page = 0;
//        int size = 1;
//        boolean orderAsc = true;
//        PagedResultResponse<CategoryResponse> response = categoryServiceImp.getCategoriesPaginated(page, size, orderAsc);
//
//        assertNotNull(response);
//    }
}