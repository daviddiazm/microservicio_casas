package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MunicipalityEntityMapper.class)
public interface DepartmentEntityMapper {
    @Mapping(source = "municipalities", target = "municipalities")
    DepartmentEntity modelToEntity(DepartmentModel departmentModel);

    @Mapping(source = "municipalities", target = "municipalities")
    DepartmentModel entityToModel(DepartmentEntity departmentEntity);
}
