package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;
import com.daviddiazm.housing.category.infrastructure.entities.CategoryEntity;
import com.daviddiazm.housing.category.infrastructure.mappers.CategoryEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.CategoryRepository;
import com.daviddiazm.housing.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void saveCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityCategoryToCategoryModel(categoryRepository.findByName(categoryName));
    }

    @Override
    public List<CategoryModel> getCategoriesByName(String categoryName) {

        return categoryEntityMapper.entityListToModelList(categoryRepository.findByNameContaining(categoryName));
    }

    @Override
    public PagedResult<CategoryModel> getCategoriesPaginated(int page, int size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        }
        Page<CategoryEntity> categoryPage = categoryRepository.findAll(pagination);
        List<CategoryModel> cagories = categoryEntityMapper.entityListToModelList(categoryRepository.findAll(pagination).getContent());

        return new PagedResult<>(
                cagories,
                page,
                size,
                orderAsc,
                categoryPage.getTotalElements(),
                categoryPage.getTotalPages()
        );

    }


}
