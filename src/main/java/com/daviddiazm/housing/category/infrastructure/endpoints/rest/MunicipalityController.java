package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.GetMunicipalitiesPagedRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveMunicipalityRequest;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveMunicipalityResponse;
import com.daviddiazm.housing.category.application.services.MunicipalityService;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
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
@RequestMapping("/api/municipalities")
@RequiredArgsConstructor
@Tag(
        name = "location",
        description = "The following endpoints are used to create and retrieve municipalities/locations"
)
public class MunicipalityController {

    private final MunicipalityService municipalityService;

    @Operation(
            method = "POST",
            summary = "Save municipality",
            description = "this endpoint is used to save municipality",
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "the name of the municipality you want to add",
                            example = "popayan"
                    ),
                    @Parameter(
                            name = "description",
                            description = "this area is for the municipality you want yo add",
                            example = "Es una ciudad del suroccidente colombiano"
                    ),
                    @Parameter(
                            name = "department id",
                            description = "this area make the relation whit a department",
                            example = "1"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Two text type data are entered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveMunicipalityRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The municipality was successfully saved in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveMunicipalityResponse.class)
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
                            description = "enter a municipality that already exists",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    @PostMapping("/")
    ResponseEntity<SaveMunicipalityResponse> saveMunicipalityController( @RequestBody SaveMunicipalityRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(municipalityService.saveMunicipality(request));
    }

    @GetMapping("/")
    ResponseEntity<PagedResultResponse<MunicipalityModel>> getMunicipalitiesPaginated (
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam boolean orderAsc,
            @RequestParam String name
    ) {
        GetMunicipalitiesPagedRequest request = new GetMunicipalitiesPagedRequest(page,size,orderAsc,name);
        return ResponseEntity.ok().body(municipalityService.getMunicipalitiesPaginated(request));
    }
}
