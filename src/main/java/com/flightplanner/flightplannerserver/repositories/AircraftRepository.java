package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.AircraftEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface defining the repository operations for database queries involving aircraft entities.
 *
 * @since 2024-04-29
 */

@Repository
public interface AircraftRepository extends CrudRepository<AircraftEntity, Long> {

    List<AircraftEntity> findAllByAircraftMake(String aircraftMake);

    List<AircraftEntity> findAllByAircraftType(String aircraftType);

    boolean existsByAircraftMakeAndAircraftModel(String aircraftMake, String aircraftModel);
}
