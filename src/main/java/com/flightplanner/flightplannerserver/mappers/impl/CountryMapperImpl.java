package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.CountryDto;
import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Service implementation for mapping between CountryEntity and CountryDto objects.
 *
 * @since 2024-04-22
 */

@Component
public class CountryMapperImpl implements Mapper<CountryEntity, CountryDto> {

    private final ModelMapper modelMapper;

    public CountryMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    /**
     * Maps a CountryEntity to a CountryDto.
     *
     * @param countryEntity The CountryEntity to map from.
     * @return The mapped CountryDto.
     */
    @Override
    public CountryDto mapTo(CountryEntity countryEntity) { return modelMapper.map(countryEntity, CountryDto.class); }

    /**
     * Maps a CountryDto to a CountryEntity.
     *
     * @param countryDto The CountryDto to map from.
     * @return The mapped CountryEntity.
     */
    @Override
    public CountryEntity mapFrom(CountryDto countryDto) { return modelMapper.map(countryDto, CountryEntity.class); }
}
