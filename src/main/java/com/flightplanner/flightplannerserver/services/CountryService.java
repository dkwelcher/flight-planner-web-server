package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.CountryDto;

/**
 * Interface defining the service operation for managing country DTOs.
 *
 * @since 2024-04-22
 */

public interface CountryService {

    /**
     * Saves a country entity to the repository.
     *
     * @param countryDto The saved country DTO.
     */
    void save(CountryDto countryDto);
}
