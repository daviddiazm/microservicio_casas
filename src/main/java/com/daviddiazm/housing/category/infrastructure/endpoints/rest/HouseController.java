package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.SaveHouseRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveHouseResponse;
import com.daviddiazm.housing.category.application.services.HouseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/house")
@RequiredArgsConstructor
@Tag(
        name = "house",
        description = "The following endpoints are used to create and retrieve locations"
)
public class HouseController {

    private final HouseService houseService;

    @PostMapping("/")
    ResponseEntity<SaveHouseResponse> savePostHouse(@RequestBody SaveHouseRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(houseService.saveHouse(request));
    }
}
