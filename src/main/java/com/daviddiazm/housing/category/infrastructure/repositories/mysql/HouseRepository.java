package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

//    @Query(
//            value = """
//                SELECT house.id, address, house.bathrooms_quantity, house.create_date, house.description, house.name, house.price, house.publish_date, house.publish_state, house.rooms_quantity, house.category_id, house.location_id
//                FROM house
//                WHERE DATE(house.publish_date) = '2025-04-12' AND house.publish_state = 'PUBLICACION_PAUSADA'
//                """,
//            nativeQuery = true
//    )
//    List<HouseEntity> getAllTodayPausedHouses();

}
