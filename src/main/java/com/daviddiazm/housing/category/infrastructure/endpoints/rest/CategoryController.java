package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.SaveCategoryRequest;
import com.daviddiazm.housing.category.application.dtos.responses.CategoryResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveCategoryResponse;
import com.daviddiazm.housing.category.application.services.CategoryService;
import com.daviddiazm.housing.commons.configurations.utils.Constants;
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

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Tag(
        name = "Categorias",
        description = "Se utilizan los siguientes endponints para crear y obtener las categorías"
)
public class CategoryController {

//    http://localhost:8081/swagger-ui/index.html


    private final CategoryService categoryService;

    @PostMapping("/")
    @Operation(
            method = "POST",
            summary = "Guardar categoria",
            description = "Este endpont se utiliza para guardar las categorias",
            tags = {"Categorias"},
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "el nombre de la categoria que desea añadir",
                            example = "condominio"
                    ),
                    @Parameter(
                            name = "description",
                            description = "La descripcion de la categoria que desea añadir",
                            example = "régimen de propiedad en el que varias personas son copropietarias de un bien inmueble"
                    ),
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Se ingresa dos datos de tipo texto",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveCategoryRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Se logro guardar la categoria en la base de datos",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveCategoryResponse.class)
                            )
                    )
            }

    )
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
