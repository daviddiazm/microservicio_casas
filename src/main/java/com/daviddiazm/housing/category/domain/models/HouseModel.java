package com.daviddiazm.housing.category.domain.models;

import com.daviddiazm.housing.category.domain.enums.PublishState;

import java.time.LocalDate;

public class HouseModel {
    private Long id;
    private String name;
    private String description;
    private int roomsQuantity;
    private int bathroomsQuantity;
    private String address;
    private double price;
    private LocalDate createDate;
    private LocalDate publishDate;
    private CategoryModel category;
    private LocationModel location;
    private PublishState publishState;

    public HouseModel() {
    }

    public HouseModel(Long id, String name, String description, int roomsQuantity, int bathroomsQuantity, String address, double price, LocalDate createDate, LocalDate publishDate, CategoryModel category, LocationModel location, PublishState publishState) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.roomsQuantity = roomsQuantity;
        this.bathroomsQuantity = bathroomsQuantity;
        this.address = address;
        this.price = price;
        this.createDate = createDate;
        this.publishDate = publishDate;
        this.category = category;
        this.location = location;
        this.publishState = publishState;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public PublishState getPublishState() {
        return publishState;
    }

    public void setPublishState(PublishState publishState) {
        this.publishState = publishState;
    }

    @Override
    public String toString() {
        return "HouseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", roomsQuantity=" + roomsQuantity +
                ", bathroomsQuantity=" + bathroomsQuantity +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", publishDate=" + publishDate +
                ", category=" + category +
                ", location=" + location +
                ", publishState=" + publishState +
                '}';
    }
}
