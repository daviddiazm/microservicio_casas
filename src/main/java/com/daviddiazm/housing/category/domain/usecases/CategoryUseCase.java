package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExist;
import com.daviddiazm.housing.category.domain.models.CategoryModel;
import com.daviddiazm.housing.category.domain.ports.in.CategoryServicePort;
import com.daviddiazm.housing.category.domain.ports.out.CategoryPersistencePort;
import java.util.List;

public class CategoryUseCase implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase( CategoryPersistencePort categoryPersistencePort ){
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if(category != null) {
            throw new NameAlreadyExist("El nombre ya existe");
        }
        categoryPersistencePort.save(categoryModel);
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }
}
