package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.MunicipalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<MunicipalityEntity, Long> {
}
