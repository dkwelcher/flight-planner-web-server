package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;
import com.flightplanner.flightplannerserver.domain.entities.ContinentEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Service implementation for mapping between ContinentEntity and ContinentDto objects.
 *
 * @since 2024-04-22
 */

@Component
public class ContinentMapperImpl implements Mapper<ContinentEntity, ContinentDto> {

    private final ModelMapper modelMapper;

    public ContinentMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    /**
     * Maps a ContinentEntity to a ContinentDto.
     *
     * @param continentEntity The ContinentEntity to map from.
     * @return The mapped ContinentDto.
     */
    @Override
    public ContinentDto mapTo(ContinentEntity continentEntity) { return modelMapper.map(continentEntity, ContinentDto.class); }

    /**
     * Maps a ContinentDto to a ContinentEntity.
     *
     * @param continentDto The ContinentDto to map from.
     * @return The mapped ContinentEntity.
     */
    @Override
    public ContinentEntity mapFrom(ContinentDto continentDto) { return modelMapper.map(continentDto, ContinentEntity.class); }
}
