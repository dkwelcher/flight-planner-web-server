package com.flightplanner.flightplannerserver.controllers;

import com.flightplanner.flightplannerserver.domain.dto.AirportDto;
import com.flightplanner.flightplannerserver.services.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling airport-related operations.
 *
 * @since 2024-04-29
 */

@RestController
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) { this.airportService = airportService; }

    /**
     * Creates a new airport record.
     *
     * @param airportDto Data transfer object representing the airport to be created.
     * @return A ResponseEntity containing the created airport or an error status.
     */
    @PostMapping(path = "/airports")
    public ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto) {
        AirportDto savedAirportDto = airportService.save(airportDto);
        return new ResponseEntity<>(savedAirportDto, HttpStatus.CREATED);
    }

    /**
     * Updates an existing airport record.
     *
     * @param airportId The ID of the airport to update.
     * @param airportDto Data transfer object representing the updated airport details.
     * @return A ResponseEntity containing the updated airport or an error status.
     */
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

    /**
     * Retrieves an AirportDto of a specific ID if the specified airport exists.
     *
     * @param airportId The ID of the airport being queried.
     * @return A ResponseEntity containing the queried airport or an HTTP 404 Not Found status, otherwise a ResponseEntity containing an error status.
     */
    @GetMapping(path = "/airports/{airportId}")
    public ResponseEntity<AirportDto> findAirportById(@PathVariable("airportId") long airportId) {
        Optional<AirportDto> airportDto = airportService.findById(airportId);
        return airportDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves an AirportDto of a specific ICAO if the specified airport exists.
     *
     * @param icao The String representation of the ICAO code of the airport being queried.
     * @return A ResponseEntity containing the queried airport or an HTTP 404 Not Found status, otherwise a ResponseEntity containing an error status.
     */
    @GetMapping(path = "/airports/icao/{icao}")
    public ResponseEntity<AirportDto> findAirportByIcao(@PathVariable("icao") String icao) {
        Optional<AirportDto> airportDto = airportService.findByIcao(icao);
        return airportDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves a list of airports with matching country name (e.g., United States, Germany, or China).
     *
     * @param countryName The String representation of the country of airports being queried.
     * @return A ResponseEntity containing a list of AirportDtos or an error status.
     */
    @GetMapping(path = "/airports/country/{countryName}")
    public ResponseEntity<List<AirportDto>> listAllAirportsByCountryName(@PathVariable("countryName") String countryName) {
        List<AirportDto> airportDtos = airportService.findAllByCountryName(countryName);
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    /**
     * Retrieves a list of airports that provide the Jet-A fuel type.
     *
     * @return A ResponseEntity containing a list of AirportDtos or an error status.
     */
    @GetMapping(path = "/airports/jeta")
    public ResponseEntity<List<AirportDto>> listAllAirportsByIsJetaAvailable() {
        List<AirportDto> airportDtos = airportService.findAllByIsJetaAvailable();
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    /**
     * Retrieves a list of airports that provide the Avgas fuel type.
     *
     * @return A ResponseEntity containing a list of AirportDtos or an error status.
     */
    @GetMapping(path = "/airports/avgas")
    public ResponseEntity<List<AirportDto>> listAllAirportsByIsAvgasAvailable() {
        List<AirportDto> airportDtos = airportService.findAllByIsAvgasAvailable();
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    /**
     * Retrieves a list of all airports.
     *
     * @return A ResponseEntity containing a list of AirportDtos or an error status.
     */
    @GetMapping(path = "/airports/all")
    public ResponseEntity<List<AirportDto>> listAllAirports() {
        List<AirportDto> airportDtos = airportService.findAll();
        return new ResponseEntity<>(airportDtos, HttpStatus.OK);
    }

    /**
     * Deletes an airport record.
     *
     * @param airportId The ID of the airport to be deleted.
     * @return A ResponseEntity indicating the HTTP status result of the delete operation.
     */
    @DeleteMapping(path = "/airports/{airportId}")
    public ResponseEntity<HttpStatus> deleteAirport(@PathVariable("airportId") long airportId) {
        airportService.deleteById(airportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
