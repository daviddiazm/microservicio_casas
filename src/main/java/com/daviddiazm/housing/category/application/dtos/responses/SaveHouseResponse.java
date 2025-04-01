package com.daviddiazm.housing.category.application.dtos.responses;

import java.time.LocalDate;

public record SaveHouseResponse(String message, LocalDate localDate) {
}
