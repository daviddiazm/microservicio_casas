package com.daviddiazm.housing.category.application.dtos.requests;

public record GetMunicipalitiesPagedRequest(int page, int size, boolean orderAsc, String name) {
}
