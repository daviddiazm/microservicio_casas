package com.daviddiazm.housing.category.domain.models;

public class LocationModel {
    private Long id;
    private String sector;
    private MunicipalityModel municipalityModel;

    public LocationModel(Long id, String sector, MunicipalityModel municipalityModel) {
        this.id = id;
        this.sector = sector;
        this.municipalityModel = municipalityModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public MunicipalityModel getMunicipalityModel() {
        return municipalityModel;
    }

    public void setMunicipalityModel(MunicipalityModel municipalityModel) {
        this.municipalityModel = municipalityModel;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "id=" + id +
                ", sector='" + sector + '\'' +
                ", municipalityModel=" + municipalityModel +
                '}';
    }
}

