package com.flightplanner.flightplannerserver.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representation of an aircraft, mapping to the "aircraft" table in the database.
 *
 * @since 2024-04-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "aircraft")
public class AircraftEntity {

    /**
     * An attribute representing the primary key of the aircraft.
     * The persistence provider assigns the primary key using a database identity column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aircraftId;

    /**
     * An attribute representing the make of the aircraft (e.g., Boeing or Airbus).
     */
    private String aircraftMake;

    /**
     * An attribute representing the model of the aircraft (e.g., 747 or A380).
     */
    private String aircraftModel;

    /**
     * An attribute representing the type of aircraft (e.g., jet, turboprop, or prop).
     */
    private String aircraftType;

    /**
     * An attribute representing the type of fuel used by the aircraft (e.g., Jet-A or Avgas).
     */
    private String fuelType;

    /**
     * An attribute representing the size of the aircraft's fuel tank measured in liters.
     */
    private double fuelTankSize;

    /**
     * An attribute representing the fuel burn rate of the aircraft measured in liters per hour at cruise speed.
     */
    private double fuelBurnRate;

    /**
     * An attribute representing the air speed of the aircraft measured in knots at cruise speed.
     */
    private double airspeed;

    /**
     * An attribute representing the maximum range of the aircraft measured in nautical miles.
     */
    private double range;

    /**
     * An attribute representing the aircraft's minimum runway length required to land measured in feet.
     */
    private double minimumRunwayLengthRequired;
}
