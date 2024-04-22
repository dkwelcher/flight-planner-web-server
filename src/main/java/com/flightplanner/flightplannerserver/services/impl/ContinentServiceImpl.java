package com.flightplanner.flightplannerserver.services.impl;

import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;
import com.flightplanner.flightplannerserver.domain.entities.ContinentEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import com.flightplanner.flightplannerserver.repositories.ContinentRepository;
import com.flightplanner.flightplannerserver.services.ContinentService;
import org.springframework.stereotype.Service;

@Service
public class ContinentServiceImpl implements ContinentService {

    private final ContinentRepository continentRepository;
    private final Mapper<ContinentEntity, ContinentDto> continentMapper;

    public ContinentServiceImpl(ContinentRepository continentRepository, Mapper<ContinentEntity, ContinentDto> continentMapper) {
        this.continentRepository = continentRepository;
        this.continentMapper = continentMapper;
    }

    @Override
    public void save(ContinentDto continentDto) {

        ContinentEntity continentEntity = continentMapper.mapFrom(continentDto);
        continentRepository.save(continentEntity);
    }
}