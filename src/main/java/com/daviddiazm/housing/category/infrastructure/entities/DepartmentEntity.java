package com.daviddiazm.housing.category.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
