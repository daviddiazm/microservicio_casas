package com.daviddiazm.housing.category.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private MunicipalityEntity municipality;

    @OneToMany(
            targetEntity= HouseEntity.class,
            mappedBy = "location",
            fetch = FetchType.LAZY)
    private List<HouseEntity> houses;

}
