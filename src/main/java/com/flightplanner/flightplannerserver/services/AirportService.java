package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.domain.dto.AirportDto;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    AirportDto save(AirportDto airportDto);
    AirportDto update(AirportDto airportDto);
    Optional<AirportDto> findById(Long airportId);
    Optional<AirportDto> findByIcao(String icao);
    List<AirportDto> findAllByCountryName(String countryName);
    List<AirportDto> findAllByIsJetaAvailable();
    List<AirportDto> findAllByIsAvgasAvailable();
    List<AirportDto> findAll();
    boolean existsById(Long airportId);
    void deleteById(Long airportId);
}
