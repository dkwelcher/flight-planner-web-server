package com.flightplanner.flightplannerserver.controllers;

import com.flightplanner.flightplannerserver.domain.dto.AirportDto;
import com.flightplanner.flightplannerserver.services.AirportService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Log
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) { this.airportService = airportService; }

    @PostMapping(path = "/airports")
    public ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto) {
        AirportDto savedAirportDto = airportService.save(airportDto);
        return new ResponseEntity<>(savedAirportDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/airports/{airportId}")
    public ResponseEntity<AirportDto> updateAirport(
            @PathVariable("airportId") long airportId,
            @RequestBody AirportDto airportDto) {

        if(airportDto.getAirportId() != airportId) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        AirportDto updatedAirportDto = airportService.update(airportDto);
        if(updatedAirportDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(updatedAirportDto, HttpStatus.OK);
    }

    @GetMapping(path = "/airports/{airportId}")
    public ResponseEntity<AirportDto> findAirportById(@PathVariable("airportId") long airportId) {
        Optional<AirportDto> airportDto = airportService.findById(airportId);
        return airportDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/airports/icao/{icao}")
    public ResponseEntity<AirportDto> findAirportByIcao(@PathVariable("icao") String icao) {
        Optional<AirportDto> airportDto = airportService.findByIcao(icao);
        return airportDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/airports/country/{countryName}")
    public ResponseEntity<List<AirportDto>> listAllAirportsByCountryName(@PathVariable("countryName") String countryName) {
        List<AirportDto> airportDtos = airportService.findAllByCountryName(countryName);
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/airports/jeta")
    public ResponseEntity<List<AirportDto>> listAllAirportsByIsJetaAvailable() {
        List<AirportDto> airportDtos = airportService.findAllByIsJetaAvailable();
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/airports/avgas")
    public ResponseEntity<List<AirportDto>> listAllAirportsByIsAvgasAvailable() {
        List<AirportDto> airportDtos = airportService.findAllByIsAvgasAvailable();
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/airports/all")
    public ResponseEntity<List<AirportDto>> listAllAirports() {
        List<AirportDto> airportDtos = airportService.findAll();
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    @DeleteMapping(path = "/airports/{airportId}")
    public ResponseEntity<HttpStatus> deleteAirport(@PathVariable("airportId") long airportId) {
        airportService.deleteById(airportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
