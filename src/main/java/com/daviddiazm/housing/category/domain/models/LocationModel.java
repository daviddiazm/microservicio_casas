package com.daviddiazm.housing.category.domain.models;

import java.util.List;

public class LocationModel {
    private Long id;
    private String sector;
    private MunicipalityModel municipalityModel;
    private List<HouseModel> houses;

    public LocationModel() {
    }

    public LocationModel(Long id, String sector, MunicipalityModel municipalityModel, List<HouseModel> houses) {
        this.id = id;
        this.sector = sector;
        this.municipalityModel = municipalityModel;
        this.houses = houses;
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

    public List<HouseModel> getHouses() {
        return houses;
    }

    public void setHouses(List<HouseModel> houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "id=" + id +
                ", sector='" + sector + '\'' +
                ", municipalityModel=" + municipalityModel +
                ", houses=" + houses +
                '}';
    }
}

