package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {

    private long flightId;
    private long startingAirportId;
    private long destinationAirportId;
    private long aircraftId;
    private List<FlightLegDto> flightLegs;
    private double totalDistance; // measured in nautical miles
    private double totalDuration; //measured in hours
}
