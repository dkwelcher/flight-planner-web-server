package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.AirportEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface defining the repository operations for database queries involving airport entities.
 *
 * @since 2024-04-29
 */

@Repository
public interface AirportRepository extends CrudRepository<AirportEntity, Long> {

    boolean existsByIcao(String icao);

    Optional<AirportEntity> findByIcao(String icao);
    @Query("SELECT a FROM AirportEntity a WHERE a.country.countryName = :countryName")
    List<AirportEntity> findAllByCountryName(String countryName);

    @Query("SELECT a FROM AirportEntity a WHERE a.isJetaAvailable = true")
    List<AirportEntity> findAllByIsJetaAvailable();

    @Query("SELECT a FROM AirportEntity a WHERE a.isAvgasAvailable = true")
    List<AirportEntity> findAllByIsAvgasAvailable();
}
