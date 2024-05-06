package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.AirportDto;
import com.flightplanner.flightplannerserver.domain.entities.AirportEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Service implementation for mapping between AirportEntity and AirportDto objects.
 *
 * @since 2024-04-22
 */

@Component
public class AirportMapperImpl implements Mapper<AirportEntity, AirportDto> {

    private final ModelMapper modelMapper;

    public AirportMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    /**
     * Maps an AirportEntity to an AirportDto.
     *
     * @param airportEntity The AircraftEntity to map from.
     * @return The mapped AirportDto.
     */
    @Override
    public AirportDto mapTo(AirportEntity airportEntity) {
        return modelMapper.map(airportEntity, AirportDto.class);
    }

    /**
     * Maps an AirportDto to an AirportEntity.
     *
     * @param airportDto The AirportDto to map from.
     * @return The mapped AirportEntity.
     */
    @Override
    public AirportEntity mapFrom(AirportDto airportDto) {
        return modelMapper.map(airportDto, AirportEntity.class);
    }
}
