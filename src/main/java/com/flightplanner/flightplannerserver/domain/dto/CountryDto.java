package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for a country.
 *
 * @since 2024-04-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {

    /**
     * An attribute representing the database identification number of the country.
     */
    private long countryId;

    /**
     * An attribute representing the name of the country (e.g., United States, Germany, or China).
     */
    private String countryName;

    /**
     * A ContinentDto representing the continent of where the country is located.
     */
    private ContinentDto continent;
}
