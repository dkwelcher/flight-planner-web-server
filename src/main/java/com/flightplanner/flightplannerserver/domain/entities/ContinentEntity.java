package com.flightplanner.flightplannerserver.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representation of a continent, mapping to the "continents" table in the database.
 *
 * @since 2024-04-22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "continents")
public class ContinentEntity {

    /**
     * An attribute representing the primary key of the continent.
     * The persistence provider assigns the primary key using a database identity column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long continentId;

    /**
     * An attribute representing the name of the continent (e.g., North America, Europe, or Asia).
     */
    private String continentName;
}
