package com.daviddiazm.housing.category.infrastructure.mappers;

import com.daviddiazm.housing.category.domain.models.DepartmentModel;
import com.daviddiazm.housing.category.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentEntityMapper {

    @Mapping(target = "municipalities", ignore = true)
    DepartmentModel entityToModel(DepartmentEntity departmentEntity);

    @Mapping(source = "municipalities", target = "municipalities")
    DepartmentEntity modelToEntity(DepartmentModel departmentModel);
}