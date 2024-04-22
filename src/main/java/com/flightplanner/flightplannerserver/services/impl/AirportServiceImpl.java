package com.flightplanner.flightplannerserver.services.impl;

import com.flightplanner.flightplannerserver.domain.dto.AirportDto;
import com.flightplanner.flightplannerserver.domain.entities.AirportEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import com.flightplanner.flightplannerserver.repositories.AirportRepository;
import com.flightplanner.flightplannerserver.services.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final Mapper<AirportEntity, AirportDto> airportMapper;

    public AirportServiceImpl(AirportRepository airportRepository, Mapper<AirportEntity, AirportDto> airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    @Override
    public AirportDto save(AirportDto airportDto) {

        AirportEntity airportEntity = airportMapper.mapFrom(airportDto);
        AirportEntity savedAirportEntity = airportRepository.save(airportEntity);
        return airportMapper.mapTo(savedAirportEntity);
    }

    @Override
    public AirportDto update(AirportDto airportDto) {

        AirportEntity airportEntity = airportMapper.mapFrom(airportDto);
        AirportEntity updatedAirportEntity = airportRepository.save(airportEntity);
        return airportMapper.mapTo(updatedAirportEntity);
    }

    @Override
    public Optional<AirportDto> findById(Long airportId) {

        Optional<AirportEntity> airportEntity = airportRepository.findById(airportId);
        return airportEntity.map(airportMapper::mapTo);
    }

    @Override
    public List<AirportDto> findAll() {
        return StreamSupport
                .stream(airportRepository
                        .findAll()
                        .spliterator(),
                        false)
                .map(airportMapper::mapTo)
                .collect(Collectors.toList()
                );
    }

    @Override
    public boolean existsById(Long airportId) { return airportRepository.existsById(airportId); }

    @Override
    public void deleteById(Long airportId) { airportRepository.deleteById(airportId); }
}
