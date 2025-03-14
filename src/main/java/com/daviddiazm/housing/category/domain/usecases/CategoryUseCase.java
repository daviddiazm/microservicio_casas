package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.exceptions.CategoryNotExist;
import com.daviddiazm.housing.category.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.housing.category.domain.exceptions.DescriptionMinException;
import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExist;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;

import java.util.List;

public class CategoryUseCase implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase( CategoryPersistencePort categoryPersistencePort ){
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if(category != null) {
            throw new NameAlreadyExist(DomainConstants.NAME_ALREADY_EXIST);
        }
        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryModel> getCategoriesByName(String name) {
        List<CategoryModel> listCategories = categoryPersistencePort.getCategoriesByName(name);
        if(listCategories.isEmpty()) {
          throw new CategoryNotExist(DomainConstants.CATEGORY_NO_EXIST);
        }
        if(name.length() < DomainConstants.MIN_NAME_CARACTER_LENGTH) {
            throw new DescriptionMinException(DomainConstants.DESCRIPTION_MIN_LENGHT);
        } else if (name.length() > DomainConstants.MAX_NAME_CARACTER_LENGTH ) {
            throw new DescriptionMaxException(DomainConstants.DESCRIPTION_MAX_LENGHT);
        }

        return listCategories;
    }

    @Override
    public PagedResult<CategoryModel> getCategoriesPaginated(int page, int size, boolean orderAsc) {
        return categoryPersistencePort.getCategoriesPaginated(page, size, orderAsc);
    }



}
