package com.daviddiazm.housing.category.application.dtos.responses;

import java.util.List;

public record PagedResultResponse<T>(
        List<T> content,
        int page,
        int size,
        boolean orderAsc,
        long totalElements,
        int totalPages) {
}
