package com.flightplanner.flightplannerserver.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representation of an airport, mapping to the "airports" table in the database.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "airports")
public class AirportEntity {

    /**
     * An attribute representing the primary key of the airport.
     * The persistence provider assigns the primary key using a database identity column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * A CountryEntity representing the country of where the airport is located.
     * The relationship is specified as Many-To-One (i.e., many airports to one country).
     * The CountryEntity is joined to the "airports" table by "countryId" which is a foreign key.
     */
    @ManyToOne
    @JoinColumn(name = "countryId")
    private CountryEntity country;

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
