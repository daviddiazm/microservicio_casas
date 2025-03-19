package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.DepartmentIdNotExist;
import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExist;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.ports.out.DepartmentPersistencePort;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.domain.utils.factories.DepartmentFactory;
import com.daviddiazm.housing.category.domain.utils.factories.MunicipalityFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MunicipalityUseCaseTest {

    @Mock
    MunicipalityPersistencePort municipalityPersistencePort;

    @Mock
    DepartmentPersistencePort departmentPersistencePort;

    @InjectMocks
    MunicipalityUseCase municipalityUseCase;

    @Test
    void saveMunicipality_WhenDepartmentNotExist_ThrowsDepartmentIdNotExist() {
        MunicipalityModel municipalityModel = MunicipalityFactory.createMunicipality();
        when(departmentPersistencePort.getDepartmentById(municipalityModel.getDepartmentModel().getId())).thenReturn(null);

        assertThrows(DepartmentIdNotExist.class, () -> municipalityUseCase.saveMunicipality(municipalityModel));
    }

    @Test
    void saveMunicipality_WhenMunicipalityNameNotExist_Expect_SavesSuccessfully() {
        MunicipalityModel municipalityModel = MunicipalityFactory.createMunicipality();
        DepartmentModel departmentModel = DepartmentFactory.createDepartment();
        List<MunicipalityModel> municipalities = new ArrayList<>();
        departmentModel.setMunicipalities(municipalities);
        municipalityModel.setDepartmentModel(departmentModel);

        when(departmentPersistencePort.getDepartmentById(municipalityModel.getDepartmentModel().getId())).thenReturn(departmentModel);

        municipalityUseCase.saveMunicipality(municipalityModel);
        verify(municipalityPersistencePort).saveMunicipality(municipalityModel);
    }

    @Test
    void saveMunicipality_WhenMunicipalityNameAlreadyExist_ThrowsNameAlreadyExist() {
        MunicipalityModel municipalityModel = MunicipalityFactory.createMunicipality();
        DepartmentModel departmentModel = DepartmentFactory.createDepartment();
        List<MunicipalityModel> municipalities = new ArrayList<>();
        municipalities.add(municipalityModel);
        departmentModel.setMunicipalities(municipalities);
        municipalityModel.setDepartmentModel(departmentModel);

        when(departmentPersistencePort.getDepartmentById(municipalityModel.getDepartmentModel().getId())).thenReturn(departmentModel);

        assertThrows(NameAlreadyExist.class, () -> municipalityUseCase.saveMunicipality(municipalityModel));
    }
}