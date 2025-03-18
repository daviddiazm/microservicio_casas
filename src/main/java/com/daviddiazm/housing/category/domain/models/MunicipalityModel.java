package com.daviddiazm.housing.category.domain.models;

public class MunicipalityModel {
    private Long id;
    private String name;
    private String description;
    private DepartmentModel departmentModel;

    public MunicipalityModel() {
    }

    public MunicipalityModel(Long id, String name, String description, DepartmentModel departmentModel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.departmentModel = departmentModel;
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

    @Override
    public String toString() {
        return "MunicipalityModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", departmentModel=" + departmentModel +
                '}';
    }
}
