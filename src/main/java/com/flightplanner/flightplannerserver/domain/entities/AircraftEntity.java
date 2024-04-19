package com.flightplanner.flightplannerserver.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "aircraft")
public class AircraftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aircraftId;

    private String aircraftMake;
    private String aircraftModel;
    private String aircraftType;
    private double fuelTankSize; // measured in liters
    private double fuelBurnRate; // measured in liters per hour at cruise speed
    private double airspeed; // measured in knots at cruise speed
    private double range; // measured in nautical miles
    private double maximumRunwayLength; // measured in feet
}
