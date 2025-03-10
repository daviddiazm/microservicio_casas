package com.daviddiazm.housing.category.application.services.impl;

import com.daviddiazm.housing.category.application.dtos.requests.GetPaginationRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.mappers.CategoryDtoMapper;
import com.daviddiazm.housing.category.application.services.CategoryService;
import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryDtoMapper categoryDtoMapper;
    private final CategoryServicePort categoryServicePort;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save( categoryDtoMapper.requestToModel(request) );
        return new SaveCategoryResponse("se creo satisfactoriamente", LocalDateTime.now());
    }

    @Override
    public List<CategoryResponse> getCategoriesPaginated(GetPaginationRequest paginationRequest) {
        return categoryDtoMapper.modelListToResponseList(
                categoryServicePort.getCategoriesPaginated(categoryDtoMapper.toPaginationRequest(paginationRequest))
        );
    }
}
