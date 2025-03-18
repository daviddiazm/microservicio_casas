package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MunicipalityEntityMapper.class)
public interface DepartmentEntityMapper {

    DepartmentEntity modelToEntity(DepartmentModel departmentModel);

    DepartmentModel entityToModel(DepartmentEntity departmentEntity);

}
