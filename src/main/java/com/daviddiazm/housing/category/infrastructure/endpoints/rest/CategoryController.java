package com.daviddiazm.housing.category.infrastructure.endpoints.rest;


import com.daviddiazm.housing.category.application.dtos.requests.GetPaginationRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> getCategoriesPaged (@RequestBody GetPaginationRequest paginationBody) {
        return ResponseEntity.ok().body(categoryService.getCategoriesPaginated(paginationBody));
    }
}
