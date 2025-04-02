package com.daviddiazm.housing.category.domain.utils.factories;

import com.daviddiazm.housing.category.domain.enums.PublishState;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.models.HouseModel;
import com.daviddiazm.housing.category.domain.models.LocationModel;

import java.time.LocalDate;

public class HouseFactory {
    public static HouseModel createHouse() {

        Long id = 1L;
        String name = "casa uno";
        String description = "una descipcion de la casa";
        int roomsQuantity = 6;
        int bathroomsQuantity = 4;
        String address = "calle cuarta";
        double price = 100.1;
        LocalDate createDate = LocalDate.of(2025,4,1);
        LocalDate publishDate = LocalDate.of(2025,4,13);
        CategoryModel categoryModel = CategoryFactory.createCategory();
        LocationModel locationModel = LocationFactory.createLocation();
        PublishState publishState = PublishState.PUBLICACION_PAUSADA;

        return new HouseModel(id,name,description,roomsQuantity,bathroomsQuantity,address,price,createDate,publishDate,categoryModel,locationModel,publishState);
    }
}
