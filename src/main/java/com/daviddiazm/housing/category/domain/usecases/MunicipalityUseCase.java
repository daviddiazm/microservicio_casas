package com.daviddiazm.housing.category.domain.usecases;

import com.daviddiazm.housing.category.domain.exceptions.DepartmentIdNotExist;
import com.daviddiazm.housing.category.domain.exceptions.NameAlreadyExist;
import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.ports.in.MunicipalityServicePort;
import com.daviddiazm.housing.category.domain.ports.out.DepartmentPersistencePort;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.domain.utils.constants.MunicipalityConstants;
import com.daviddiazm.housing.category.domain.utils.validations.MunicipalityValidator;

import java.util.List;

public class MunicipalityUseCase implements MunicipalityServicePort {

    private MunicipalityPersistencePort municipalityPersistencePort;
    private DepartmentPersistencePort departmentPersistencePort;

    public MunicipalityUseCase(
            MunicipalityPersistencePort municipalityPersistencePort,
            DepartmentPersistencePort departmentPersistencePort) {
        this.municipalityPersistencePort = municipalityPersistencePort;
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public void saveMunicipality(MunicipalityModel municipalityModel) {
        DepartmentModel department = departmentPersistencePort.getDepartmentById(municipalityModel.getDepartmentModel().getId());

        municipalityModel.setName(municipalityModel.getName().toLowerCase());
        municipalityModel.setDescription(municipalityModel.getDescription().toLowerCase());

        MunicipalityValidator.validateName(municipalityModel.getName());
        MunicipalityValidator.validateDescription(municipalityModel.getDescription());

        MunicipalityModel municipalityExist = getMunicipalityModel(municipalityModel.getName(), department);
        if(municipalityExist != null) {
            throw new NameAlreadyExist(MunicipalityConstants.NAME_ALREADY_EXIST);
        }

        municipalityPersistencePort.saveMunicipality(municipalityModel);
    }

    @Override
    public PagedResult<MunicipalityModel> getMunicipalitiesPaginated(int page, int size, boolean orderAsc, String name) {
        return municipalityPersistencePort.getMunicipalitiesPaginated(page, size, orderAsc, name);
    }

    private static MunicipalityModel getMunicipalityModel(String nameMunicipality, DepartmentModel department) {
        MunicipalityModel municipalityExist = null;

        if(department == null) {
            throw new DepartmentIdNotExist(MunicipalityConstants.DEPARTMENT_MUNICIPALITY_NOT_EXIST);
        } else {
            List<MunicipalityModel> municipalities = department.getMunicipalities();
            if(!municipalities.isEmpty()) {
                for(MunicipalityModel municipality : municipalities) {
                    if(municipality.getName().equals(nameMunicipality)) {
                        municipalityExist = municipality;
                    }
                }
            }
        }
        return municipalityExist;
    }
}
