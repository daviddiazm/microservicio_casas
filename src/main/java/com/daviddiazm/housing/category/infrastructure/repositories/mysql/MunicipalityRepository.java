package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.MunicipalityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MunicipalityRepository extends JpaRepository<MunicipalityEntity, Long> {
    @Query(
            value = """
                    SELECT municipality.id AS id, municipality.name, municipality.description, municipality.department_id, department.id AS id_department, department.name AS name_department, department.description AS description_department
                    FROM municipality,department
                    WHERE municipality.department_id = department.id AND (municipality.name LIKE %:value% OR department.name LIKE %:value%)
                    """,
            nativeQuery = true
    )
    Page<MunicipalityEntity> findMunicipalities(@Param("value") String name, Pageable pageable);
}
