package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.GetFilterHousePagedRequest;
import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.HouseResponse;
import com.daviddiazm.housing.category.application.dtos.responses.PagedResultResponse;
import com.daviddiazm.housing.category.application.dtos.responses.SaveHouseResponse;
import com.daviddiazm.housing.category.application.services.HouseService;
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
@RequestMapping("/api/house")
@RequiredArgsConstructor
@Tag(
        name = "house",
        description = "The following endpoints are used to create and retrieve your house"
)
public class HouseController {

//    http://localhost:8081/swagger-ui/index.html


    private final HouseService houseService;

    @Operation(
            method = "POST",
            summary = "Save house",
            description = "this endpoint is used to save house",
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "the name of the house you want to add",
                            example = "Casa sur occidente"
                    ),
                    @Parameter(
                            name = "description",
                            description = "the description of the house you want to add",
                            example = "Casa sur-occidente de color azul"
                    ),
                    @Parameter(
                            name = "rooms quantity",
                            description = "this area contain the rooms number from your house",
                            example = "1"
                    ),
                    @Parameter(
                            name = "bathrooms quantity",
                            description = "this area contain the bathrooms number from your house",
                            example = "1"
                    ),
                    @Parameter(
                            name = "address",
                            description = "the address of the house you want to add",
                            example = "Cr 48E #1-93"
                    ),
                    @Parameter(
                            name = "price",
                            description = "the price of the house you want to add",
                            example = "200.2"
                    ),
                    @Parameter(
                            name = "publish date",
                            description = "the publish date of the house you want to add",
                            example = "25-04-13"
                    ),
                    @Parameter(
                            name = "category id",
                            description = "the category of the house you want to add",
                            example = "1"
                    ),
                    @Parameter(
                            name = "location id",
                            description = "the location of the house you want to add",
                            example = "1"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Two text type data are entered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveHouseRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The house was successfully saved in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveHouseResponse.class)
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
                            description = "enter a house that already exists",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    @PostMapping("/")
    ResponseEntity<SaveHouseResponse> savePostHouse(@RequestBody SaveHouseRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(houseService.saveHouse(request));
    }

    @GetMapping("/")
    ResponseEntity<PagedResultResponse<HouseResponse>> filterHousePaged(
                                                        @RequestParam int page,
                                                        @RequestParam int size,
                                                        @RequestParam boolean orderAsc,
                                                        @RequestParam Long idLocation,
                                                        @RequestParam Long idCategory,
                                                        @RequestParam int roomsQuantity,
                                                        @RequestParam int bathroomsQuantity,
                                                        @RequestParam double minPrice,
                                                        @RequestParam double maxPrice){
        GetFilterHousePagedRequest request = new GetFilterHousePagedRequest(page,size,orderAsc,idLocation,idCategory,roomsQuantity,bathroomsQuantity,minPrice,maxPrice);
        return ResponseEntity.ok().body(houseService.filterHousePaged(request));
    }
}
