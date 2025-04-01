package com.daviddiazm.housing.category.domain.models;

import java.util.List;

public class MunicipalityModel {
    private Long id;
    private String name;
    private String description;
    private DepartmentModel departmentModel;
    private List<LocationModel> locations;

    public MunicipalityModel() {
    }

    public MunicipalityModel(Long id, String name, String description, DepartmentModel departmentModel, List<LocationModel> locations) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.departmentModel = departmentModel;
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DepartmentModel getDepartmentModel() {
        return departmentModel;
    }

    public void setDepartmentModel(DepartmentModel departmentModel) {
        this.departmentModel = departmentModel;
    }

    public List<LocationModel> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationModel> locations) {
        this.locations = locations;
    }
}
