package com.flightplanner.flightplannerserver.controllers;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.services.AircraftService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Log
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    // POST /aircraft
    @PostMapping(path = "/aircraft")
    public ResponseEntity<AircraftDto> createAircraft(@RequestBody AircraftDto aircraftDto) {

        AircraftDto savedAircraftDto = aircraftService.save(aircraftDto);
        return new ResponseEntity<>(savedAircraftDto, HttpStatus.CREATED);
    }

    // PUT /aircraft/123
    @PutMapping(path = "/aircraft/{aircraftId}")
    public ResponseEntity<AircraftDto> updateAircraft(
            @PathVariable("aircraftId") long aircraftId,
            @RequestBody AircraftDto aircraftDto) {

        if(aircraftDto.getAircraftId() != aircraftId) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        AircraftDto updatedAircraftDto = aircraftService.update(aircraftDto);
        if(updatedAircraftDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(updatedAircraftDto, HttpStatus.OK);
    }

    // GET /aircraft/123
    @GetMapping(path = "/aircraft/{aircraftId}")
    public ResponseEntity<AircraftDto> findAircraftById(@PathVariable("aircraftId") long aircraftId) {

        Optional<AircraftDto> aircraftDto = aircraftService.findById(aircraftId);
        return aircraftDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET /aircraft/all
    @GetMapping(path = "/aircraft/all")
    public ResponseEntity<List<AircraftDto>> listAllAircraft() {

        List<AircraftDto> aircraftDtos = aircraftService.findAll();
        return new ResponseEntity<>(aircraftDtos, HttpStatus.OK);
    }

    // DELETE /aircraft/123
    @DeleteMapping(path = "/aircraft/{aircraftId}")
    public ResponseEntity<HttpStatus> deleteAircraft(@PathVariable("aircraftId") long aircraftId) {

        aircraftService.deleteById(aircraftId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
