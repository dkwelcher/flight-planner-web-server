package com.flightplanner.flightplannerserver.controllers;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.services.AircraftService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling aircraft-related operations.
 *
 * @since 2024-04-29
 */

@RestController
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    /**
     * Creates a new aircraft record.
     *
     * @param aircraftDto Data transfer object representing the aircraft to be created.
     * @return A ResponseEntity containing the created aircraft or an error status.
     */
    @PostMapping(path = "/aircraft")
    public ResponseEntity<AircraftDto> createAircraft(@RequestBody @Valid AircraftDto aircraftDto) {

        AircraftDto savedAircraftDto = aircraftService.save(aircraftDto);
        return new ResponseEntity<>(savedAircraftDto, HttpStatus.CREATED);
    }

    /**
     * Updates an existing aircraft record.
     *
     * @param aircraftId The ID of the aircraft to update.
     * @param aircraftDto Data transfer object representing the updated aircraft details.
     * @return A ResponseEntity containing the updated aircraft or an error status.
     */
    @PutMapping(path = "/aircraft/{aircraftId}")
    public ResponseEntity<AircraftDto> updateAircraft(
            @PathVariable("aircraftId") long aircraftId,
            @RequestBody @Valid AircraftDto aircraftDto) {

        if(aircraftDto.getAircraftId() != aircraftId) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        AircraftDto updatedAircraftDto = aircraftService.update(aircraftDto);
        if(updatedAircraftDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(updatedAircraftDto, HttpStatus.OK);
    }

    /**
     * Retrieves an AircraftDto of a specific ID if the specified aircraft exists.
     *
     * @param aircraftId The ID of the aircraft being queried.
     * @return A ResponseEntity containing the queried aircraft or an HTTP 404 Not Found status, otherwise a ResponseEntity containing an error status.
     */
    @GetMapping(path = "/aircraft/{aircraftId}")
    public ResponseEntity<AircraftDto> findAircraftById(@PathVariable("aircraftId") long aircraftId) {

        Optional<AircraftDto> aircraftDto = aircraftService.findById(aircraftId);
        return aircraftDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves a list of aircraft with matching aircraft make (e.g., Boeing or Airbus).
     *
     * @param aircraftMake The String representation of the aircraft make being queried.
     * @return A ResponseEntity containing a list of AircraftDtos or an error status.
     */
    @GetMapping(path = "/aircraft/make/{aircraftMake}")
    public ResponseEntity<List<AircraftDto>> listAllAircraftByMake(@PathVariable("aircraftMake") String aircraftMake) {
        List<AircraftDto> aircraftDtos = aircraftService.findAllByAircraftMake(aircraftMake);
        return new ResponseEntity<>(aircraftDtos, HttpStatus.OK);
    }

    /**
     * Retrieves a list of aircraft with matching aircraft type (e.g., Jet, Turboprop, or Prop).
     *
     * @param aircraftType The String representation of the aircraft type being queried.
     * @return A ResponseEntity containing a list of AircraftDtos or an error status.
     */
    @GetMapping(path = "/aircraft/type/{aircraftType}")
    public ResponseEntity<List<AircraftDto>> listAllAircraftByType(@PathVariable("aircraftType") String aircraftType) {
        List<AircraftDto> aircraftDtos = aircraftService.findAllByAircraftType(aircraftType);
        return new ResponseEntity<>(aircraftDtos, HttpStatus.OK);
    }

    /**
     * Retrieves a list of all aircraft.
     *
     * @return A ResponseEntity containing a list of AircraftDtos or an error status.
     */
    @GetMapping(path = "/aircraft/all")
    public ResponseEntity<List<AircraftDto>> listAllAircraft() {

        List<AircraftDto> aircraftDtos = aircraftService.findAll();
        return new ResponseEntity<>(aircraftDtos, HttpStatus.OK);
    }

    /**
     * Deletes an aircraft record.
     *
     * @param aircraftId The ID of the aircraft to be deleted.
     * @return A ResponseEntity indicating the HTTP status result of the delete operation.
     */
    @DeleteMapping(path = "/aircraft/{aircraftId}")
    public ResponseEntity<HttpStatus> deleteAircraft(@PathVariable("aircraftId") long aircraftId) {

        aircraftService.deleteById(aircraftId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
