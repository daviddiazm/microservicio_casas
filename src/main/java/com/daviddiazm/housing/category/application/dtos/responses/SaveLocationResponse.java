package com.daviddiazm.housing.category.application.dtos.responses;

import java.time.LocalDate;

public record SaveLocationResponse(String message, LocalDate localDate) {
}
