package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightLegDto {

    private long flightLegId;
    private long flightId;
    private long startingAirportId;
    private long destinationAirportId;
    private int flightLegNumber;
    private double distance; // measured in nautical miles
    private double duration; // measure in hours
    private String cardinalDirection;
}
