package com.daviddiazm.housing.category.infrastructure.repositories.mysql;

import com.daviddiazm.housing.category.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Page<CategoryEntity> findAll(Pageable pageable);
}
