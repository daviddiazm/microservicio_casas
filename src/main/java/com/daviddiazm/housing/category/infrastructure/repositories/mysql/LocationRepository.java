package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<LocationEntity , Long> {

//    @Query(
//            value = """
//                    SELECT location.id AS id, location.sector AS sector, location.municipality_id, municipality.id AS municipality_id, municipality.name, municipality.description, municipality.department_id, department.id AS id_department, department.name AS name_department, department.description AS description_department
//                    FROM municipality,department, location
//                    WHERE municipality.department_id = department.id AND location.municipality_id = municipality.id (municipality.name LIKE %:value% OR department.name LIKE %:value%)
//                    """,
//            nativeQuery = true
//    )
    @Query(
            value = """
                    municipality_id
                    SELECT municipality.id, municipality.name, municipality.description, municipality.department_id
                    FROM municipality
                    
                    """,
            nativeQuery = true
    )
    Page<LocationEntity> locationsByMunicipalityOrDepartmentName(@Param("value") String name, Pageable pageable);
}
