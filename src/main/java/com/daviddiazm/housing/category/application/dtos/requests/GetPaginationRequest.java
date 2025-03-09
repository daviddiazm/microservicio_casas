package com.daviddiazm.housing.category.application.dtos.requests;

public record GetPaginationRequest(int page, int size, boolean orderAsc) {
}
