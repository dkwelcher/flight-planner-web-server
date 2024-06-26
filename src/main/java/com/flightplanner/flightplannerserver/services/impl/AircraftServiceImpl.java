package com.flightplanner.flightplannerserver.services.impl;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.domain.entities.AircraftEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import com.flightplanner.flightplannerserver.repositories.AircraftRepository;
import com.flightplanner.flightplannerserver.services.AircraftService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service implementation for managing aircraft DTOs.
 * See interface for general comments. Implementation-specific comments are provided only if necessary.
 *
 * @since 2024-04-29
 */

@Service
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;
    private final Mapper<AircraftEntity, AircraftDto> aircraftMapper;

    public AircraftServiceImpl(AircraftRepository aircraftRepository, Mapper<AircraftEntity, AircraftDto> aircraftMapper) {
        this.aircraftRepository = aircraftRepository;
        this.aircraftMapper = aircraftMapper;
    }

    @Override
    public AircraftDto save(AircraftDto aircraftDto) {
        aircraftDto.setRange(calculateAircraftRange(aircraftDto.getFuelTankSize(),
                                                    aircraftDto.getFuelBurnRate(),
                                                    aircraftDto.getAirspeed()));
        AircraftEntity aircraftEntity = aircraftMapper.mapFrom(aircraftDto);
        AircraftEntity savedAircraftEntity =  aircraftRepository.save(aircraftEntity);
        return aircraftMapper.mapTo(savedAircraftEntity);
    }

    @Override
    public AircraftDto update(AircraftDto aircraftDto) {
        aircraftDto.setRange(calculateAircraftRange(aircraftDto.getFuelTankSize(),
                                                    aircraftDto.getFuelBurnRate(),
                                                    aircraftDto.getAirspeed()));
        AircraftEntity aircraftEntity = aircraftMapper.mapFrom(aircraftDto);
        AircraftEntity updatedAircraftEntity = aircraftRepository.save(aircraftEntity);
        return aircraftMapper.mapTo(updatedAircraftEntity);
    }

    @Override
    public Optional<AircraftDto> findById(Long aircraftId) {
        Optional<AircraftEntity> aircraftEntity = aircraftRepository.findById(aircraftId);
        return aircraftEntity.map(aircraftMapper::mapTo);
    }

    @Override
    public List<AircraftDto> findAllByAircraftMake(String aircraftMake) {
        return aircraftRepository
                .findAllByAircraftMake(aircraftMake)
                .stream()
                .map(aircraftMapper::mapTo)
                .collect(Collectors.toList()
                );
    }

    @Override
    public List<AircraftDto> findAllByAircraftType(String aircraftType) {
        return aircraftRepository
                .findAllByAircraftType(aircraftType)
                .stream()
                .map(aircraftMapper::mapTo)
                .collect(Collectors.toList()
                );
    }

    @Override
    public List<AircraftDto> findAll() {
        return StreamSupport
                .stream(aircraftRepository
                        .findAll()
                        .spliterator(),
                        false)
                .map(aircraftMapper::mapTo)
                .collect(Collectors.toList()
                );
    }

    @Override
    public boolean existsById(Long aircraftId) {
        return aircraftRepository.existsById(aircraftId);
    }

    @Override
    public void deleteById(Long aircraftId) {
        aircraftRepository.deleteById(aircraftId);
    }

    private double calculateAircraftRange(double fuelTankSize, double fuelBurnRate, double airspeed) {
        return Math.floor(fuelTankSize / fuelBurnRate * airspeed);
    }
}
