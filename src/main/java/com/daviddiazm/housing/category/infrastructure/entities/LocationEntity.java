package com.daviddiazm.housing.category.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sector;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "municipality_id")
    private MunicipalityEntity municipalityEntity;

}
