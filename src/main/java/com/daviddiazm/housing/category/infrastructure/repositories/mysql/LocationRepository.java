package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<LocationEntity , Long> {

    @Query(
            value = """
        SELECT DISTINCT l FROM LocationEntity l
        JOIN FETCH l.municipality m
        JOIN FETCH m.department d
        WHERE (l.sector LIKE %:value%
            OR m.name LIKE %:value%
            OR d.name LIKE %:value%)
        """,
            countQuery = """
        SELECT COUNT(DISTINCT l.id) FROM LocationEntity l
        JOIN l.municipality m
        JOIN m.department d
        WHERE (l.sector LIKE %:value%
            OR m.name LIKE %:value%
            OR d.name LIKE %:value%)
        """)
    Page<LocationEntity> locationsByMunicipalityOrDepartmentName(
            @Param("value") String value,
            Pageable pageable);

    @Query("""
    SELECT COUNT(DISTINCT l.id) 
    FROM LocationEntity l
    JOIN l.municipality m
    JOIN m.department d
    WHERE (l.sector LIKE %:value%
        OR m.name LIKE %:value%
        OR d.name LIKE %:value%)
    """)
    long countAllLocations(@Param("value") String value);

    @Query("SELECT DISTINCT l FROM LocationEntity l WHERE l.municipality.id = :cityId")
    List<LocationEntity> getLocationByCiyId(long cityId);
}