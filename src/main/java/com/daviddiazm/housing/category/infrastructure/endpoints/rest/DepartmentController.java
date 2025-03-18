package com.daviddiazm.housing.category.infrastructure.endpoints.rest;

import com.daviddiazm.housing.category.application.dtos.requests.SaveDepartmentRequest;
import com.daviddiazm.housing.category.application.dtos.responses.SaveDepartmentResponse;
import com.daviddiazm.housing.category.application.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
//    http://localhost:8081/swagger-ui/index.html

    private final DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<SaveDepartmentResponse> saveDepartmentController(SaveDepartmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.saveDepartment(request));
    }
}
