package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.HouseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {

    @Query(
            value = """
                SELECT house.id, address, house.bathrooms_quantity, house.create_date, house.description, house.name, house.price, house.publish_date, house.publish_state, house.rooms_quantity, house.category_id, house.location_id
                FROM house
                WHERE DATE(house.publish_date) = CURDATE() AND house.publish_state = 'PUBLICACION_PAUSADA'
                """,
            nativeQuery = true
    )
    List<HouseEntity> getAllTodayPausedHouses();



    @Query(
        value = """
                SELECT house.id AS id, house.address, house.bathrooms_quantity, house.create_date, house.description, house.name, house.price, house.publish_date, house.publish_state, house.rooms_quantity, category.id AS category_id, category.name AS category_name, category.description AS category_description, location.id AS location_id, location.sector
                FROM house , category, location
                WHERE house.category_id = category.id AND house.location_id = location.id AND (:category = 0 OR house.category_id = :category) AND (:location = 0 OR house.location_id = :location) AND (:roomsQuantity = 0 OR house.rooms_quantity = :roomsQuantity) AND (:bathroomsQuantity = 0 OR house.bathrooms_quantity = :bathroomsQuantity) AND (house.price BETWEEN :minPrice AND :maxPrice)
                """,
        nativeQuery = true
    )
    Page<HouseEntity> findHouses(
            @Param("location") Long location,
            @Param("category") Long category,
            @Param("roomsQuantity") int roomsQuantity,
            @Param("bathroomsQuantity") int bathroomsQuantity,
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice,
            Pageable pageable
    );

}
