package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.ContinentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface defining the repository operations for database queries involving continent entities.
 *
 * @since 2024-04-22
 */

@Repository
public interface ContinentRepository extends CrudRepository<ContinentEntity, Long> {

    ContinentEntity findByContinentName(String continentName);

    boolean existsByContinentName(String continentName);
}
