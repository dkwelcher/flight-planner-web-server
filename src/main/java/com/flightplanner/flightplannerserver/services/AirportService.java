package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.domain.dto.AirportDto;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    AirportDto save(AirportDto airportDto);
    AirportDto update(AirportDto airportDto);
    Optional<AirportDto> findById(Long airportId);
    List<AirportDto> findAll();
    boolean existsById(Long airportId);
    void deleteById(Long airportId);
}
