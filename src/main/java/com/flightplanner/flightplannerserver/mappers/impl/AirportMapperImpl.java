package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.AirportDto;
import com.flightplanner.flightplannerserver.domain.entities.AirportEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AirportMapperImpl implements Mapper<AirportEntity, AirportDto> {

    private final ModelMapper modelMapper;

    public AirportMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Override
    public AirportDto mapTo(AirportEntity airportEntity) {
        return modelMapper.map(airportEntity, AirportDto.class);
    }

    @Override
    public AirportEntity mapFrom(AirportDto airportDto) {
        return modelMapper.map(airportDto, AirportEntity.class);
    }
}
