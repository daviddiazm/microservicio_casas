package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.infrastructure.mappers.MunicipalityEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.MunicipalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MunicipalityPersistenceAdapter implements MunicipalityPersistencePort {
    private final MunicipalityRepository municipalityRepository;
    private final MunicipalityEntityMapper municipalityEntityMapper;

    @Override
    public void saveMunicipality(MunicipalityModel municipalityModel) {
        municipalityRepository.save(municipalityEntityMapper.modelToEntity(municipalityModel));
    }
}
