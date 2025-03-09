package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import com.daviddiazm.housing.category.infrastructure.mappers.CategoryEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return null;
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return List.of();
    }
}
