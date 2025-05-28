package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.infrastructure.scheduleds.HouseScheduled;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/house-test")
@RequiredArgsConstructor
@Tag(
        name = "house",
        description = "The following endpoints are used to create and retrieve your house"
)
public class HouseSheduleCrontrollerTest {
    private final HouseScheduled houseScheduled;

    @GetMapping("/run-scheduled-task")
    public String runScheduledTask() {
        houseScheduled.updateStateTodayHouses();
        return "Tarea programada ejecutada manualmente.";
    }
}
