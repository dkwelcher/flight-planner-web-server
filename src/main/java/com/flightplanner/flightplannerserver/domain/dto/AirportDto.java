package com.flightplanner.flightplannerserver.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty
    private String icao;

    /**
     * An attribute representing the name of the airport (e.g., Chicago O'Hare International Airport).
     */
    @NotEmpty
    private String airportName;

    /**
     * A CountryDto representing the country of where the airport is located.
     */
    @NotNull
    private CountryDto country;

    /**
     * An attribute representing the latitude coordinate of the airport (e.g., 33.9416).
     */
    @Min(-90)
    @Max(90)
    private double latitude;

    /**
     * An attribute representing the longitude coordinate of the airport (e.g., -118.4085).
     */
    @Min(-180)
    @Max(180)
    private double longitude;

    /**
     * A boolean representing the availability of Jet-A fuel at the airport.
     */
    @NotNull
    private boolean isJetaAvailable;

    /**
     * A boolean representing the availability of Avgas fuel at the airport.
     */
    @NotNull
    private boolean isAvgasAvailable;

    /**
     * An attribute representing the airport's longest runway measured in feet.
     */
    @Min(0)
    @Max(100000)
    private double maximumRunwayLength;
}
