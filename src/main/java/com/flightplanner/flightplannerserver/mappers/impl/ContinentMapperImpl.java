package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;
import com.flightplanner.flightplannerserver.domain.entities.ContinentEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapperImpl implements Mapper<ContinentEntity, ContinentDto> {

    private final ModelMapper modelMapper;

    public ContinentMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Override
    public ContinentDto mapTo(ContinentEntity continentEntity) { return modelMapper.map(continentEntity, ContinentDto.class); }

    @Override
    public ContinentEntity mapFrom(ContinentDto continentDto) { return modelMapper.map(continentDto, ContinentEntity.class); }
}
