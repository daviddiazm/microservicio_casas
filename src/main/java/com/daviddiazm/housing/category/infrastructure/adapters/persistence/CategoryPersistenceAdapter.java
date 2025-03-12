package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.dtos.requests.PaginationRequest;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import com.daviddiazm.housing.category.infrastructure.mappers.CategoryEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
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
        return null;
    }

    @Override
    public List<CategoryModel> getCategoriesByName(String categoryName) {

        return categoryEntityMapper.entityListToModelList(categoryRepository.findByNameContaining(categoryName));
    }

    @Override
    public List<CategoryModel> getCategoriesPaginated(PaginationRequest paginationRequest) {
        Pageable pagination;
        int page = paginationRequest.getPage();
        int size = paginationRequest.getSize();
        if (paginationRequest.isOrderAsc()) {
            pagination = PageRequest.of(page, size, Sort.by("name").ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by("name").descending());
        }
        return categoryEntityMapper.entityListToModelList(categoryRepository.findAll(pagination).getContent());
    }


}
