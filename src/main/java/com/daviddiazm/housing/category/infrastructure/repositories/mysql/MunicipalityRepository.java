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
                    SELECT municipality.name, department.name
                    FROM  municipality
                    JOIN  departments ON municipality.department_id
                    WHERE municipality.name LIKE %:name%
                    OR    department.name LIKE %:name%
                    """,
            nativeQuery = true
    )
    Page<MunicipalityEntity> findMunicipalities (@Param("name") String name, Pageable pageable);
}
