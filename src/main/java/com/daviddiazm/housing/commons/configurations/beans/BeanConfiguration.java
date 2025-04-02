package com.daviddiazm.housing.commons.configurations.beans;

import com.daviddiazm.housing.category.domain.ports.in.*;
import com.daviddiazm.housing.category.domain.ports.out.*;
import com.daviddiazm.housing.category.domain.usecases.*;
import com.daviddiazm.housing.category.infrastructure.adapters.persistence.*;
import com.daviddiazm.housing.category.infrastructure.mappers.*;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    private final DepartmentRespository departmentRespository;
    private final DepartmentEntityMapper departmentEntityMapper;

    private final MunicipalityRepository municipalityRepository;
    private final MunicipalityEntityMapper municipalityEntityMapper;

    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    private final HouseRepository houseRepository;
    private final HouseEntityMapper houseEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }


    @Bean
    public DepartmentServicePort departmentServicePort() {
        return new DepartmentUseCase(departmentPersistencePort());
    }

    @Bean
    public DepartmentPersistencePort departmentPersistencePort() {
        return new DepartmentPersistenceAdapter(departmentRespository, departmentEntityMapper);
    }


    @Bean
    public MunicipalityServicePort municipalityServicePort() {
        return new MunicipalityUseCase(municipalityPersistencePort(), departmentPersistencePort());
    }

    @Bean
    public MunicipalityPersistencePort municipalityPersistencePort() {
        return new MunicipalityPersistenceAdapter(municipalityRepository, municipalityEntityMapper);
    }


    @Bean
    public LocationServicePort locationServicePort () {
        return new LocationUseCase(locationPersistencePort(), municipalityPersistencePort());
    }

    @Bean
    public LocationPersistencePort locationPersistencePort() {
        return  new LocationPersistenceAdapter(locationRepository, locationEntityMapper);
    }


    @Bean
    public HouseServicePort houseServicePort(){
        return new HouseUseCase(housePersistencePort());
    }

    @Bean
    public HousePersistencePort housePersistencePort() {
        return new HousePersistenceAdapter(houseRepository, houseEntityMapper);
    }
}
