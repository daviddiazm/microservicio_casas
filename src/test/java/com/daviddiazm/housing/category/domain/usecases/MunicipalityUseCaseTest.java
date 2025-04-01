package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.DepartmentIdNotExistException;
import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExistException;
import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbrePageException;
import com.daviddiazm.housing.category.domain.exceptions.PageMinNumbreSizeException;
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

        assertThrows(DepartmentIdNotExistException.class, () -> municipalityUseCase.saveMunicipality(municipalityModel));
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

        assertThrows(NameAlreadyExistException.class, () -> municipalityUseCase.saveMunicipality(municipalityModel));
    }

    @Test
    void When_GetMunicipalitiesPaginated_PageIsLessThatZero_Throw_PageMinNumberPage () {
        int page = -1;
        int size = 2;
        boolean ordAsc = true;
        String nameSearch = "name";
        assertThrows(PageMinNumbrePageException.class, () -> municipalityUseCase.getMunicipalitiesPaginated(page, size,ordAsc,nameSearch));
    }
    @Test
    void When_GetMunicipalitiesPaginated_SizeIsLessThatOne_Throw_SizeMinNumberPage () {
        int page = 0;
        int size = 0;
        boolean ordAsc = true;
        String nameSearch = "name";
        assertThrows(PageMinNumbreSizeException.class, () -> municipalityUseCase.getMunicipalitiesPaginated(page,size,ordAsc,nameSearch));
    }
}