package com.daviddiazm.housing.category.application.dtos.responses;

import java.time.LocalDateTime;

public record SaveCategoryResponse(String message, LocalDateTime time) {
}
