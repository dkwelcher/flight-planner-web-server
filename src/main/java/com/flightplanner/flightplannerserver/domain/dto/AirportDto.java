package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportDto {

    private long airportId;
    private String icao;
    private String airportName;
    private ContinentDto continent;
    private CountryDto country;
    private double latitude;
    private double longitude;
    private boolean isJetAAvailable;
    private boolean isAvgasAvailable;
    private double maximumRunwayLength; // measured in feet
}
