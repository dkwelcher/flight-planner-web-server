package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface defining the service operation for managing aircraft DTOs.
 *
 * @since 2024-04-29
 */

public interface AircraftService {

    /**
     * Saves an aircraft entity to the repository.
     *
     * @param aircraftDto The aircraft DTO to save.
     * @return The saved aircraft DTO.
     */
    AircraftDto save(AircraftDto aircraftDto);

    /**
     * Updates an aircraft entity.
     *
     * @param aircraftDto The aircraft DTO to update.
     * @return The updated aircraft DTO.
     */
    AircraftDto update(AircraftDto aircraftDto);

    /**
     * Finds aircraft entity by its ID.
     *
     * @param aircraftId The ID of the aircraft.
     * @return An Optional containing the aircraft DTO if found, or an empty Optional otherwise.
     */
    Optional<AircraftDto> findById(Long aircraftId);

    /**
     * Finds all aircraft entities associated with a specific make.
     *
     * @param aircraftMake The make of the aircraft.
     * @return A list of aircraft DTOs associated with the make.
     */
    List<AircraftDto> findAllByAircraftMake(String aircraftMake);

    /**
     * Finds all aircraft entities associated with a specific type.
     *
     * @param aircraftType The type of the aircraft.
     * @return A list of aircraft DTOs with the associated type.
     */
    List<AircraftDto> findAllByAircraftType(String aircraftType);

    /**
     * Finds all aircraft entities.
     *
     * @return A list of all aircraft DTOs.
     */
    List<AircraftDto> findAll();

    /**
     * Checks if an aircraft entity exists by its ID.
     *
     * @param aircraftId The ID of the aircraft entity being checked.
     * @return true if the entity exists, false otherwise.
     */
    boolean existsById(Long aircraftId);

    /**
     * Deletes an aircraft entity by its ID.
     *
     * @param aircraftId The ID of the aircraft entity to delete.
     */
    void deleteById(Long aircraftId);
}
