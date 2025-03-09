package com.daviddiazm.housing.commons.configurations.beans;

import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import com.daviddiazm.housing.category.domain.usecases.CategoryUseCase;
import com.daviddiazm.housing.category.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.daviddiazm.housing.category.infrastructure.mappers.CategoryEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }
}
