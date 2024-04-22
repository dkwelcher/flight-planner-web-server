package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.AirportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<AirportEntity, Long> {
}
