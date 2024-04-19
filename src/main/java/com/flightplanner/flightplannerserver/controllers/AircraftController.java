package com.flightplanner.flightplannerserver.controllers;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.services.AircraftService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @PostMapping(path = "/aircraft")
    public ResponseEntity<AircraftDto> createAircraft(@RequestBody AircraftDto aircraftDto) {

        AircraftDto savedAircraftDto = aircraftService.save(aircraftDto);
        return new ResponseEntity<>(savedAircraftDto, HttpStatus.CREATED);
    }
}
