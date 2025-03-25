package com.daviddiazm.housing.category.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "municipality")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MunicipalityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;
}
