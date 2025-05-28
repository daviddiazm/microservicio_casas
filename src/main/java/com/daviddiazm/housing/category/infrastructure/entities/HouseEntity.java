package com.daviddiazm.housing.category.infrastructure.entities;

import com.daviddiazm.housing.category.domain.enums.PublishState;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.models.LocationModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "house")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int roomsQuantity;
    private int bathroomsQuantity;
    private String address;
    private double price;
    private LocalDate createDate;
    private LocalDate publishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private LocationEntity location;

    @Enumerated(EnumType.STRING)
    private PublishState publishState;
}
