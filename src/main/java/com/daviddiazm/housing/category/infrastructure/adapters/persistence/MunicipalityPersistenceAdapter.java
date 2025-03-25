package com.daviddiazm.housing.category.infrastructure.adapters.persistence;

import com.daviddiazm.housing.category.domain.models.MunicipalityModel;
import com.daviddiazm.housing.category.domain.models.PagedResult;
import com.daviddiazm.housing.category.domain.ports.out.MunicipalityPersistencePort;
import com.daviddiazm.housing.category.infrastructure.entities.MunicipalityEntity;
import com.daviddiazm.housing.category.infrastructure.mappers.MunicipalityEntityMapper;
import com.daviddiazm.housing.category.infrastructure.repositories.mysql.MunicipalityRepository;
import com.daviddiazm.housing.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public PagedResult<MunicipalityModel> getMunicipalitiesPaginated(int page, int size, boolean orderAsc, String name) {
        Pageable pagination;
        if (orderAsc) {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        }
        Page<MunicipalityEntity> municpalityPage = municipalityRepository.findMunicipalities(name, pagination);
        List<MunicipalityModel> municipalities = municipalityEntityMapper.entityListToModelList(municpalityPage.getContent());

        return new PagedResult<>(
                municipalities,
                page,
                size,
                orderAsc,
                municpalityPage.getTotalElements(),
                municpalityPage.getTotalPages()
        );
    }
}
