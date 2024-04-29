package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.AircraftEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends CrudRepository<AircraftEntity, Long> {

    List<AircraftEntity> findAllByAircraftMake(String aircraftMake);

    List<AircraftEntity> findAllByAircraftType(String aircraftType);
}
