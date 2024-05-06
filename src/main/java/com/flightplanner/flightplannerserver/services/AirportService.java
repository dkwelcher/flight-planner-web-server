package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.AirportDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface defining the service operation for managing airport DTOs.
 *
 * @since 2024-04-29
 */

public interface AirportService {

    /**
     * Saves an airport entity to the repository.
     *
     * @param airportDto The aircraft DTO to save.
     * @return The saved airport DTO.
     */
    AirportDto save(AirportDto airportDto);

    /**
     * Updates an airport entity.
     *
     * @param airportDto The aircraft DTO to update.
     * @return The updated airport DTO.
     */
    AirportDto update(AirportDto airportDto);

    /**
     * Finds airport entity by its ID.
     *
     * @param airportId The ID of the aircraft.
     * @return An Optional containing the airport DTO if found, or an empty Optional otherwise.
     */
    Optional<AirportDto> findById(Long airportId);

    /**
     * Finds airport entity by its ICAO code.
     *
     * @param icao The ICAO code of the airport.
     * @return An Optional containing the AirportDTO if found, or an empty Optional otherwise.
     */
    Optional<AirportDto> findByIcao(String icao);

    /**
     * Finds all airport entities associated with a specific country.
     *
     * @param countryName The name of the country.
     * @return A list of airport DTOs with the associated country.
     */
    List<AirportDto> findAllByCountryName(String countryName);

    /**
     * Finds all airport entities that provide Jet-A fuel.
     *
     * @return A list of airport DTOs that provide Jet-A fuel.
     */
    List<AirportDto> findAllByIsJetaAvailable();

    /**
     * Finds all airport entities that provide Avgas fuel.
     *
     * @return A list of airport DTOs that provide Avgas fuel.
     */
    List<AirportDto> findAllByIsAvgasAvailable();

    /**
     * Finds all airport entities.
     *
     * @return A list of all airport DTOs.
     */
    List<AirportDto> findAll();

    /**
     * Checks if an airport exists by its ID.
     *
     * @param airportId The ID of the airport entity being checked.
     * @return true if the entity exists, false otherwise.
     */
    boolean existsById(Long airportId);

    /**
     * Deletes an airport entity by its ID.
     *
     * @param airportId The ID of the airport entity to delete.
     */
    void deleteById(Long airportId);
}
