package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.SaveDepartmentRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveDepartmentResponse;
import com.daviddiazm.housing.category.application.services.DepartmentService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
@Tag(
        name = "Departments",
        description = "The following endpoints are used to create and retrieve departments"
)
public class DepartmentController {
//    http://localhost:8081/swagger-ui/index.html

    private final DepartmentService departmentService;

    @Operation(
            method = "POST",
            summary = "Save department",
            description = "this endpoint is used to save department",
            tags = {"Department"},
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "the name of the department you want to add",
                            example = "cauca"
                    ),
                    @Parameter(
                            name = "description",
                            description = "this area is for the description you want yo add",
                            example = "Es un departamento del suroccidente colombiano"
                    ),
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Two text type data are entered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveDepartmentRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The department was successfully saved in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveDepartmentResponse.class)
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
                            description = "enter a department that already exists",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    @PostMapping("/")
    public ResponseEntity<SaveDepartmentResponse> saveDepartmentController(SaveDepartmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.saveDepartment(request));
    }
}
