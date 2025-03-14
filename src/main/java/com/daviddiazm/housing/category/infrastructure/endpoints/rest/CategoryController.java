package com.daviddiazm.housing.category.infrastructure.endpoints.rest;


import com.daviddiazm.housing.category.application.dtos.requests.GetPaginationRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.services.CategoryService;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(saveCategoryRequest));
    }


    @GetMapping("/")
    public ResponseEntity<PagedResultResponse<CategoryResponse>> getCategoriesPaged(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam boolean orderAsc) {

        return ResponseEntity.ok().body(categoryService.getCategoriesPaginated(page, size, orderAsc));
    }

    @GetMapping("/by-name/{categoryName}")
    public ResponseEntity<List<CategoryResponse>> getCategoriesByName (@PathVariable String categoryName) {
        return ResponseEntity.ok().body(categoryService.getCategotiesByName(categoryName));
    }
}
