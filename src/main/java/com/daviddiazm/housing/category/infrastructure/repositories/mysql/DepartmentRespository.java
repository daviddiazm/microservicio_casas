package com.daviddiazm.housing.category.infrastructure.repositories.mysql;
import com.daviddiazm.housing.category.infrastructure.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRespository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByName(String name);
//    DepartmentEntity findById (Long id);
}
