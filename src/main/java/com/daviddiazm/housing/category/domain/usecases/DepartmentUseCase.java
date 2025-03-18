package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExist;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.domain.ports.in.DepartmentServicePort;
import com.daviddiazm.housing.category.domain.ports.out.DepartmentPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.DepartmentConstants;
import com.daviddiazm.housing.category.domain.utils.validations.DepartmentValidator;

public class DepartmentUseCase implements DepartmentServicePort {

    private DepartmentPersistencePort departmentPersistencePort;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort) {
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public void saveDepartment(DepartmentModel departmentModel) {
        DepartmentModel departmentExist = departmentPersistencePort.getDepartmentByName(departmentModel.getName());
        if (departmentExist != null) {
            throw new NameAlreadyExist(DepartmentConstants.DEPARTMENT_ALREADY_EXIST);
        }
//        si se permiten caracteres pero no numeros
        DepartmentValidator.validateName(departmentModel.getName());
        DepartmentValidator.validateDescription(departmentModel.getDescription());
        departmentModel.setName(departmentModel.getName().toLowerCase());
        departmentModel.setDescription(departmentModel.getDescription().toLowerCase());
        departmentPersistencePort.saveDepartment(departmentModel);
    }
}
