package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.services.CategoryService;
import com.daviddiazm.housing.category.infrastructure.exceptionshandler.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Tag(
        name = "Categories",
        description = "The following endpoints are used to create and retrieve categories"
)
public class CategoryController {

//    http://localhost:8081/swagger-ui/index.html


    private final CategoryService categoryService;

    @PostMapping("/")
    @Operation(
            method = "POST",
            summary = "Save category",
            description = "Eset endpoint is used to save categories",
            tags = {"Categories"},
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "the name of the category you want to add",
                            example = "condominio"
                    ),
                    @Parameter(
                            name = "description",
                            description = "La descripcion de la categoria que desea añadir",
                            example = "régimen de propiedad en el que varias personas son copropietarias de un bien inmueble"
                    ),
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Two text type data are entered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveCategoryRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The category was successfully saved in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveCategoryResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Data was entered incorrectly",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "I enter a category that already exists",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(saveCategoryRequest));
    }


    @GetMapping("/")
    @Operation(
            method = "GET",
            summary = "Get a list of paginated categories",
            description = "Eset endpoint is used to display paginated categories",
            tags = {"Categories"},
            parameters = {
                    @Parameter(
                            name = "page",
                            description = "The page you want to be located on",
                            example = "0"
                    ),
                    @Parameter(
                            name = "size",
                            description = "The number of categories you want to see on a page",
                            example = "5"
                    ),
                    @Parameter(
                            name = "orderAsc",
                            description = "This parameter serves the function of bringing the categories ordered alphabetically with respect to their name",
                            example = "true"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The paginated categories were obtained in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = PagedResultResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Data was entered incorrectly",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    public ResponseEntity<PagedResultResponse<CategoryResponse>> getCategoriesPaged(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam boolean orderAsc) {

        return ResponseEntity.ok().body(categoryService.getCategoriesPaginated(page, size, orderAsc));
    }

}
