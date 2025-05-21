package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.GetLocationsRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveLocationRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveMunicipalityRequest;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveLocationResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveMunicipalityResponse;
import com.daviddiazm.housing.category.application.services.LocationService;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
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

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
@Tag(
        name = "location",
        description = "The following endpoints are used to create and retrieve locations"
)
public class LocationController {

    private final LocationService locationService;


    @Operation(
            method = "POST",
            summary = "Save location",
            description = "this endpoint is used to save location",
            parameters = {
                    @Parameter(
                            name = "sector",
                            description = "the name of the location you want to add",
                            example = "Maria occidente"
                    ),
                    @Parameter(
                            name = "municipality id",
                            description = "this area make the relation whit a municipality",
                            example = "1"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Two text type data are entered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveLocationRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The location was successfully saved in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveLocationResponse.class)
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
                            description = "enter a location that already exists",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    @PostMapping("/")
    ResponseEntity<SaveLocationResponse> saveLocation (@RequestBody SaveLocationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(request));
    }

    @Operation(
            method = "GET",
            summary = "get location paginated",
            description = "this endpoint is used to get municipalities by name",
            parameters = {
                    @Parameter(
                            name = "page",
                            description = "The page you want to be located on",
                            example = "0"
                    ),
                    @Parameter(
                            name = "size",
                            description = "The number of categories you want to see on a page",
                            example = "50"
                    ),
                    @Parameter(
                            name = "orderAsc",
                            description = "This parameter serves the function of bringing the categories ordered alphabetically with respect to their name",
                            example = "true"
                    ),
                    @Parameter(
                            name = "name",
                            description = "The city name or department name that you want",
                            example = "cauca"
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
    @GetMapping("/")
    ResponseEntity<PagedResult<LocationModel>> getPaginatedLocation(
            @RequestParam int page, @RequestParam int size,
            @RequestParam boolean orderAsc, @RequestParam(defaultValue = "") String name ) {
        GetLocationsRequest request = new GetLocationsRequest(page,size,orderAsc,name);
        return ResponseEntity.ok().body(locationService.getLocationsPaginated(request));
    }
}
