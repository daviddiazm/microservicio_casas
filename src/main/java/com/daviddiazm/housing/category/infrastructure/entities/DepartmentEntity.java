package com.daviddiazm.housing.category.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(
            targetEntity= MunicipalityEntity.class,
            mappedBy = "departmentEntity",
            fetch = FetchType.LAZY)
    private List<MunicipalityEntity> municipalities;
}
