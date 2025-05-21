package com.daviddiazm.housing.category.application.dtos.requests;

public record GetLocationsRequest(int page, int size, boolean orderAsc, String name) {
}
