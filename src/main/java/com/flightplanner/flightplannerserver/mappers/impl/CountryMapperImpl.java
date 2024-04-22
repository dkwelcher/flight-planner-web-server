package com.flightplanner.flightplannerserver.mappers.impl;

import com.flightplanner.flightplannerserver.domain.dto.CountryDto;
import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CountryMapperImpl implements Mapper<CountryEntity, CountryDto> {

    private final ModelMapper modelMapper;

    public CountryMapperImpl(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Override
    public CountryDto mapTo(CountryEntity countryEntity) { return modelMapper.map(countryEntity, CountryDto.class); }

    @Override
    public CountryEntity mapFrom(CountryDto countryDto) { return modelMapper.map(countryDto, CountryEntity.class); }
}
