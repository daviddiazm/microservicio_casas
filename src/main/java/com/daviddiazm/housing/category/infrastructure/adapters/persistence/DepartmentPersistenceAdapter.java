package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.ports.out.DepartmentPersistencePort;
import com.daviddiazm.housing.category.infrastructure.entities.DepartmentEntity;
import com.daviddiazm.housing.category.infrastructure.mappers.DepartmentEntityMapper;
import com.daviddiazm.housing.category.infrastructure.mappers.MunicipalityEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.DepartmentRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {

    private final DepartmentRespository departmentRespository;
    private final DepartmentEntityMapper departmentEntityMapper;
    private final MunicipalityEntityMapper municipalityEntityMapper;

    @Override
    public void saveDepartment(DepartmentModel departmentModel) {
        departmentRespository.save(departmentEntityMapper.modelToEntity(departmentModel));
    }

    @Override
    public DepartmentModel getDepartmentByName(String departmentName) {
        return departmentEntityMapper.entityToModel(departmentRespository.findByName(departmentName));
    }

    @Override
    public DepartmentModel getDepartmentById(Long id) {
        Optional<DepartmentEntity> department = departmentRespository.findById(id);
        if(department.isPresent()) {
            List<MunicipalityModel> municipalities = municipalityEntityMapper.entityListToModelList(department.get().getMunicipalities());
            return new DepartmentModel(
                    department.get().getId(),
                    department.get().getName(),
                    department.get().getDescription(),
                    municipalities
            );
        }
        return null;
    }
}
