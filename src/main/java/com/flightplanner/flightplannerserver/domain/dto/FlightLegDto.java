package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for a flight leg.
 *
 * A flight leg is one leg of a flight plan. A flight plan must have one or many flight legs.
 *
 * The destination airport of a flight leg represents an intermediate stop.
 * Each intermediate stop assumes a refueling of the aircraft.
 * For example, a flight plan that includes KJFK -> KSTL -> KLAX will have two flight legs.
 * Flight Leg 1: KJFK -> KSTL and Flight Leg 2: KSTL -> KLAX.
 * The aircraft will have refueled at KSTL to complete the flight plan.
 *
 * @since 2024-04-19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightLegDto {

    /**
     * An attribute representing the database identification number of the flight leg.
     */
    private long flightLegId;

    /**
     * A FlightPlanDto representing the flight plan to which the flight leg belongs.
     */
    private FlightPlanDto flightPlan;

    /**
     * An AirportDto representing the starting airport of the flight leg.
     */
    private AirportDto startingAirport;

    /**
     * An AirportDto representing the destination airport of the flight leg.
     */
    private AirportDto destinationAirport;

    /**
     * An attribute representing the ordinal number of the flight leg within the flight plan
     * (e.g., 1 represents the first flight leg).
     */
    private int flightLegNumber;

    /**
     * An attribute representing the total distance of the flight leg measured in nautical miles.
     */
    private double distance;

    /**
     * An attribute representing the total duration of the flight leg measured in minutes.
     */
    private double duration;

    /**
     * An attribute representing the cardinal direction of the flight leg from starting airport to destination airport
     * (e.g., "S" represents south, "NE" represents northeast).
     */
    private String cardinalDirection;
}
