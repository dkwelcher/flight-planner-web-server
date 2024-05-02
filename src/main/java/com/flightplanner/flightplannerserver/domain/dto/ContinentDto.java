package com.flightplanner.flightplannerserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for a continent.
 *
 * @since 2024-04-22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContinentDto {

    /**
     * An attribute representing the database identification number of the continent.
     */
    private long continentId;

    /**
     * An attribute representing the name of the continent (e.g., North America, Europe, or Asia).
     */
    private String continentName;
}
