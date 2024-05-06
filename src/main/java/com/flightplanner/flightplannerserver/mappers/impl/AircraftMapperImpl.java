package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.domain.entities.AircraftEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Service implementation for mapping between AircraftEntity and AircraftDto objects.
 *
 * @since 2024-04-19
 */

@Component
public class AircraftMapperImpl implements Mapper<AircraftEntity, AircraftDto> {

    private final ModelMapper modelMapper;

    public AircraftMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    /**
     * Maps an AircraftEntity to an AircraftDto.
     *
     * @param aircraftEntity The AircraftEntity to map from.
     * @return The mapped AircraftDto.
     */
    @Override
    public AircraftDto mapTo(AircraftEntity aircraftEntity) {
        return modelMapper.map(aircraftEntity, AircraftDto.class);
    }

    /**
     * Maps an AircraftDto to an AircraftEntity.
     *
     * @param aircraftDto The AircraftDto to map from.
     * @return The mapped AircraftEntity.
     */
    @Override
    public AircraftEntity mapFrom(AircraftDto aircraftDto) {
        return modelMapper.map(aircraftDto, AircraftEntity.class);
    }
}
