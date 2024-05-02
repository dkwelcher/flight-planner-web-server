package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for an airport.
 *
 * @since 2024-04-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportDto {

    /**
     * An attribute representing the database identification number of the aircraft.
     */
    private long airportId;

    /**
     * An attribute representing the ICAO code of the airport (e.g., KJFK for John F. Kennedy International Airport).
     */
    private String icao;

    /**
     * An attribute representing the name of the airport (e.g., Chicago O'Hare International Airport).
     */
    private String airportName;

    /**
     * A CountryDto representing the country of where the airport is located.
     */
    private CountryDto country;

    /**
     * An attribute representing the latitude coordinate of the airport (e.g., 33.9416).
     */
    private double latitude;

    /**
     * An attribute representing the longitude coordinate of the airport (e.g., -118.4085).
     */
    private double longitude;

    /**
     * A boolean representing the availability of Jet-A fuel at the airport.
     */
    private boolean isJetaAvailable;

    /**
     * A boolean representing the availability of Avgas fuel at the airport.
     */
    private boolean isAvgasAvailable;

    /**
     * An attribute representing the airport's longest runway measured in feet.
     */
    private double maximumRunwayLength;
}
