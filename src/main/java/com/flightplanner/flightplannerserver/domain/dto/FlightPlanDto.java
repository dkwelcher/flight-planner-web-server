package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object for a flight plan.
 *
 * @since 2024-04-19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightPlanDto {

    /**
     * An attribute representing the database identification number of the flight plan.
     */
    private long flightPlanId;

    /**
     * An AirportDto representing the starting airport of the flight plan.
     */
    private AirportDto startingAirport;

    /**
     * An AirportDto representing the destination airport of the flight plan.
     */
    private AirportDto destinationAirport;

    /**
     * An AircraftDto representing the aircraft used for the flight plan.
     */
    private AircraftDto aircraft;

    /**
     * A list of flight legs of the flight plan.
     */
    private List<FlightLegDto> flightLegs;

    /**
     * An attribute representing the total distance of the flight plan measured in nautical miles.
     */
    private double totalDistance;

    /**
     * An attribute representing the total duration of the flight plan measured in minutes.
     */
    private double totalDuration;
}
