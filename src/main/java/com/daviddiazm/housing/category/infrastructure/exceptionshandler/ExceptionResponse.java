package com.daviddiazm.housing.category.infrastructure.exceptionshandler;

import java.time.LocalDateTime;

public record ExceptionResponse(String name, LocalDateTime dateTime) {
}
