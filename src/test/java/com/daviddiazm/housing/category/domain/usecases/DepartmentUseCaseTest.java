package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExist;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.domain.ports.out.DepartmentPersistencePort;
import com.daviddiazm.housing.category.domain.utils.factories.DepartmentFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentUseCaseTest {

    @Mock
    DepartmentPersistencePort departmentPersistencePort;

    @InjectMocks
    DepartmentUseCase departmentUseCase;

    @Test
    void saveDepartment_WhenDepartmentNameNotExist_Expect_SavesSuccesfully() {
        DepartmentModel department = DepartmentFactory.createDepartment();
        when(departmentPersistencePort.getDepartmentByName(department.getName())).thenReturn(null);
        departmentUseCase.saveDepartment(department);
        verify(departmentPersistencePort).saveDepartment(department);
    }

    @Test
    void saveDepartment_WhenDepartmentAlreadyExist () {
        DepartmentModel departmentModel = DepartmentFactory.createDepartment();
        Long id = 2L;
        String name = "cesar";
        String description = "esta es una descripcion de prueba";
        DepartmentModel departmentExist = DepartmentFactory.createDepartment(id,name,description);

        when(departmentPersistencePort.getDepartmentByName(departmentModel.getName())).thenReturn(departmentExist);
        assertThrows(NameAlreadyExist.class, () -> departmentUseCase.saveDepartment(departmentModel));
    }

    @Test
    void saveDepartment_WhenDepartmentExistIsNull () {
        DepartmentModel departmentModel = DepartmentFactory.createDepartment();

    }

}