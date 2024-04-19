package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.AircraftEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends CrudRepository<AircraftEntity, Long> {
}
