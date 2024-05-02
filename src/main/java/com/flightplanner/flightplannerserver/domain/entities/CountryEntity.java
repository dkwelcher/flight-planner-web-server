package com.flightplanner.flightplannerserver.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representation of a country, mapping to the "countries" table in the database.
 *
 * @since 2024-04-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "countries")
public class CountryEntity {

    /**
     * An attribute representing the primary key of the country.
     * The persistence provider assigns the primary key using a database identity column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryId;

    /**
     * An attribute representing the name of the country (e.g., United States, Germany, or China).
     */
    private String countryName;

    /**
     * A ContinentEntity representing the continent of where the country is located.
     * The relationship is specified as Many-To-One (i.e., many countries to one continent).
     * The ContinentEntity is joined to the "countries" table by "continentId" which is a foreign key.
     */
    @ManyToOne
    @JoinColumn(name = "continentId")
    private ContinentEntity continent;
}
