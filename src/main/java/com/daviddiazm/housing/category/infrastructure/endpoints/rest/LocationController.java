package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.SaveLocationRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveLocationResponse;
import com.daviddiazm.housing.category.application.services.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
@Tag(
        name = "location",
        description = "The following endpoints are used to create and retrieve locations"
)
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/")
    ResponseEntity<SaveLocationResponse> saveLocation (SaveLocationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(request));
    }
}
