package com.daviddiazm.housing.category.application.mappers;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
    List<CategoryResponse> modelListToResponseList(List<CategoryModel> categories);

    default <T> PagedResultResponse<T> toPagedResultResponse(PagedResult<T> pagedResult) {
        return new PagedResultResponse<>(
                pagedResult.getContent(),
                pagedResult.getPage(),
                pagedResult.getSize(),
                pagedResult.isOrderAsc(),
                pagedResult.getTotalElements(),
                pagedResult.getTotalPages()
        );
    }
}


