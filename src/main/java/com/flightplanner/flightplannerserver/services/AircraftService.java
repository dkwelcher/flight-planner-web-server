package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.domain.entities.AircraftEntity;

import java.util.List;
import java.util.Optional;

public interface AircraftService {

    AircraftDto save(AircraftDto aircraftDto);

    AircraftDto update(AircraftDto aircraftDto);

    Optional<AircraftDto> findById(Long aircraftId);

    List<AircraftDto> findAll();

    boolean existsById(Long aircraftId);

    void deleteById(Long aircraftId);
}