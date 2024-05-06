package com.flightplanner.flightplannerserver.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for an aircraft.
 *
 * @since 2024-04-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AircraftDto {

    /**
     * An attribute representing the database identification number of the aircraft.
     */
    private long aircraftId;

    /**
     * An attribute representing the make of the aircraft (e.g., Boeing or Airbus).
     */
    @NotEmpty
    private String aircraftMake;

    /**
     * An attribute representing the model of the aircraft (e.g., 747 or A380).
     */
    @NotEmpty
    private String aircraftModel;

    /**
     * An attribute representing the type of aircraft (e.g., jet, turboprop, or prop).
     */
    @NotEmpty
    private String aircraftType;

    /**
     * An attribute representing the type of fuel used by the aircraft (e.g., Jet-A or Avgas).
     */
    @NotEmpty
    private String fuelType;

    /**
     * An attribute representing the size of the aircraft's fuel tank measured in liters.
     */
    @NotEmpty
    private double fuelTankSize;

    /**
     * An attribute representing the fuel burn rate of the aircraft measured in liters per hour at cruise speed.
     */
    @NotEmpty
    private double fuelBurnRate;

    /**
     * An attribute representing the air speed of the aircraft measured in knots at cruise speed.
     */
    @NotEmpty
    private double airspeed;

    /**
     * An attribute representing the maximum range of the aircraft measured in nautical miles.
     */
    private double range;

    /**
     * An attribute representing the aircraft's minimum runway length required to land measured in feet.
     */
    @NotEmpty
    private double minimumRunwayLengthRequired;
}
