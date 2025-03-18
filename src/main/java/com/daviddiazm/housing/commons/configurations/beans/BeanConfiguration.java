package com.daviddiazm.housing.commons.configurations.beans;

import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import com.daviddiazm.housing.category.domain.ports.in.DepartmentServicePort;
import com.daviddiazm.housing.category.domain.ports.in.MunicipalityServicePort;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import com.daviddiazm.housing.category.domain.ports.out.DepartmentPersistencePort;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.domain.usecases.CategoryUseCase;
import com.daviddiazm.housing.category.domain.usecases.DepartmentUseCase;
import com.daviddiazm.housing.category.domain.usecases.MunicipalityUseCase;
import com.daviddiazm.housing.category.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.daviddiazm.housing.category.infrastructure.adapters.persistence.DepartmentPersistenceAdapter;
import com.daviddiazm.housing.category.infrastructure.adapters.persistence.MunicipalityPersistenceAdapter;
import com.daviddiazm.housing.category.infrastructure.mappers.CategoryEntityMapper;
import com.daviddiazm.housing.category.infrastructure.mappers.DepartmentEntityMapper;
import com.daviddiazm.housing.category.infrastructure.mappers.MunicipalityEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.CategoryRepository;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.DepartmentRespository;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.MunicipalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
//@EnableSwagger2
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    private final DepartmentRespository departmentRespository;
    private final DepartmentEntityMapper departmentEntityMapper;

    private final MunicipalityRepository municipalityRepository;
    private final MunicipalityEntityMapper municipalityEntityMapper;

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
        return new DepartmentPersistenceAdapter(departmentRespository, departmentEntityMapper, municipalityEntityMapper);
    }

    @Bean
    public MunicipalityServicePort municipalityServicePort() {
        return new MunicipalityUseCase(municipalityPersistencePort(), departmentPersistencePort());
    }

    @Bean
    public MunicipalityPersistencePort municipalityPersistencePort() {
        return new MunicipalityPersistenceAdapter(municipalityRepository, municipalityEntityMapper);
    }

}
