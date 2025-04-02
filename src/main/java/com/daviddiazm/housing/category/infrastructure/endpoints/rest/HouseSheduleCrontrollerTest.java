package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.infrastructure.scheduleds.HouseScheduled;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
