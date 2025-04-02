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
                    SELECT house.id AS id, house.bathrooms_quantity, house.create_date, house.description, house.name, house.price, house.publish_date, house.publish_state, house.rooms_quantity, house.category_id, house.location_id, category.id AS category_id, category.name AS category_name, category.description AS category_description, location.id AS location_id, location.sector
                    FROM house, category, location
                    WHERE :category = category.id AND location = location.id (municipality.name LIKE %:value% OR department.name LIKE %:value%)
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
