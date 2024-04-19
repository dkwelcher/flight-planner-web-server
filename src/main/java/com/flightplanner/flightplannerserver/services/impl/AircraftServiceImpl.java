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

        AircraftEntity aircraftEntity = aircraftMapper.mapFrom(aircraftDto);
        AircraftEntity savedAircraftEntity =  aircraftRepository.save(aircraftEntity);
        return aircraftMapper.mapTo(aircraftEntity);
    }

    @Override
    public Optional<AircraftEntity> findById(Long aircraftId) {
        return aircraftRepository.findById(aircraftId);
    }

    @Override
    public List<AircraftEntity> findAll() {
        return StreamSupport
                .stream(aircraftRepository
                        .findAll()
                        .spliterator(),
                        false)
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
}
