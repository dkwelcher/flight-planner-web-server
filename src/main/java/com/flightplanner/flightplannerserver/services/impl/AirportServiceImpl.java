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

/**
 * Service implementation for managing airport DTOs.
 * See interface for general comments. Implementation-specific comments are provided only if necessary.
 *
 * @since 2024-04-29
 */

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
        Optional<AirportEntity> airportEntities = airportRepository.findById(airportId);
        return airportEntities.map(airportMapper::mapTo);
    }

    @Override
    public Optional<AirportDto> findByIcao(String icao) {
        Optional<AirportEntity> airportEntities = airportRepository.findByIcao(icao);
        return airportEntities.map(airportMapper::mapTo);
    }

    @Override
    public List<AirportDto> findAllByCountryName(String countryName) {
        return airportRepository
                .findAllByCountryName(countryName)
                        .stream()
                        .map(airportMapper::mapTo)
                        .collect(Collectors.toList()
                        );
    }

    @Override
    public List<AirportDto> findAllByIsJetaAvailable() {
        return airportRepository
                .findAllByIsJetaAvailable()
                .stream()
                .map(airportMapper::mapTo)
                .collect(Collectors.toList()
                );
    }

    @Override
    public List<AirportDto> findAllByIsAvgasAvailable() {
        return airportRepository
                .findAllByIsAvgasAvailable()
                .stream()
                .map(airportMapper::mapTo)
                .collect(Collectors.toList()
                );
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
