package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.domain.entities.AircraftEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapperImpl implements Mapper<AircraftEntity, AircraftDto> {

    private final ModelMapper modelMapper;

    public AircraftMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Override
    public AircraftDto mapTo(AircraftEntity aircraftEntity) {
        return modelMapper.map(aircraftEntity, AircraftDto.class);
    }

    @Override
    public AircraftEntity mapFrom(AircraftDto aircraftDto) {
        return modelMapper.map(aircraftDto, AircraftEntity.class);
    }
}
