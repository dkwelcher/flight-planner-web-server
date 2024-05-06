package com.flightplanner.flightplannerserver.services.impl;

import com.flightplanner.flightplannerserver.domain.dto.CountryDto;
import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import com.flightplanner.flightplannerserver.repositories.CountryRepository;
import com.flightplanner.flightplannerserver.services.CountryService;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing country DTOs.
 * See interface for general comments. Implementation-specific comments are provided only if necessary.
 *
 * @since 2024-04-22
 */

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final Mapper<CountryEntity, CountryDto> countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, Mapper<CountryEntity, CountryDto> countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public void save(CountryDto countryDto) {

        CountryEntity countryEntity = countryMapper.mapFrom(countryDto);
        countryRepository.save(countryEntity);
    }
}
