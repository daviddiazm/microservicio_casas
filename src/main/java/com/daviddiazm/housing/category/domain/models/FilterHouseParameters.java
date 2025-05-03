package com.daviddiazm.housing.category.domain.models;

public class FilterHouseParameters {
    private int page;
    private int size;
    private boolean orderAsc;
    private Long idLocation;
    private Long idCategory;
    private int roomsQuantity;
    private int bathroomsQuantity;
    private double minPrice;
    private double maxPrice;

    public FilterHouseParameters() {
    }

    public FilterHouseParameters(int page, int size, boolean orderAsc, Long idLocation, Long idCategory, int roomsQuantity, int bathroomsQuantity, double minPrice, double maxPrice) {
        this.page = page;
        this.size = size;
        this.orderAsc = orderAsc;
        this.idLocation = idLocation;
        this.idCategory = idCategory;
        this.roomsQuantity = roomsQuantity;
        this.bathroomsQuantity = bathroomsQuantity;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOrderAsc() {
        return orderAsc;
    }

    public void setOrderAsc(boolean orderAsc) {
        this.orderAsc = orderAsc;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public int getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(int roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }

    public int getBathroomsQuantity() {
        return bathroomsQuantity;
    }

    public void setBathroomsQuantity(int bathroomsQuantity) {
        this.bathroomsQuantity = bathroomsQuantity;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
