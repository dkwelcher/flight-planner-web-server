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
@Table(name = "airports")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airportId;

    private String icao;
    private String airportName;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private CountryEntity country;

    private double latitude;
    private double longitude;
    private boolean isJetaAvailable;
    private boolean isAvgasAvailable;
    private double maximumRunwayLength; // measured in feet
}
