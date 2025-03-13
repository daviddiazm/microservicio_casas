package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.GetPaginationRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.mappers.CategoryDtoMapper;
import com.daviddiazm.housing.category.application.services.CategoryService;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.models.PaginationRequest;
import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.daviddiazm.housing.commons.configurations.utils.Constants;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryDtoMapper categoryDtoMapper;
    private final CategoryServicePort categoryServicePort;


    @Override
    public SaveCategoryResponse saveCategory(SaveCategoryRequest request) {
        categoryServicePort.saveCategory( categoryDtoMapper.requestToModel(request) );
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PagedResultResponse<CategoryResponse> getCategoriesPaginated(GetPaginationRequest paginationRequest) {
        PaginationRequest paginationRequesModel =  categoryDtoMapper.toPaginationRequest(paginationRequest);
        PagedResult<CategoryModel> pagedResult = categoryServicePort.getCategoriesPaginated(paginationRequesModel);
        List<CategoryModel> categories = pagedResult.getContent();
        List<CategoryResponse> categoryResponses = categoryDtoMapper.modelListToResponseList(categories);
        return new PagedResultResponse<>(
                categoryResponses,
                pagedResult.getPage(),
                pagedResult.getSize(),
                pagedResult.isOrderAsc(),
                pagedResult.getTotalElements(),
                pagedResult.getTotalPages()
        );
    }

    @Override
    public List<CategoryResponse> getCategotiesByName(String categoryName) {
        return categoryDtoMapper.modelListToResponseList(categoryServicePort.getCategoriesByName(categoryName));
    }

}
