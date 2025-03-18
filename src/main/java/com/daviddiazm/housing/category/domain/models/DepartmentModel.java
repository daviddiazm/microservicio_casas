package com.daviddiazm.housing.category.domain.models;

import java.util.ArrayList;
import java.util.List;

public class DepartmentModel {
    private Long id;
    private String name;
    private String description;
    private List<MunicipalityModel> municipalities;

    public DepartmentModel(Long id, String name, String description, List<MunicipalityModel> municipalities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.municipalities = municipalities != null ? municipalities : new ArrayList<>();
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

    public List<MunicipalityModel> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(List<MunicipalityModel> municipalities) {
        this.municipalities = municipalities != null ? municipalities : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DepartmentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", municipalities=" + municipalities +
                '}';
    }
}
