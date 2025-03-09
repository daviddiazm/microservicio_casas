package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();
}
