package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.ContinentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends CrudRepository<ContinentEntity, Long> {

    ContinentEntity findByContinentName(String continentName);
}
