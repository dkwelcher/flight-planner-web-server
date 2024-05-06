package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;

/**
 * Interface defining the service operation for managing continent DTOs.
 *
 * @since 2024-04-22
 */

public interface ContinentService {

    /**
     * Saves a continent entity to the repository.
     *
     * @param continentDto The continent DTO to save.
     */
    void save(ContinentDto continentDto);
}
