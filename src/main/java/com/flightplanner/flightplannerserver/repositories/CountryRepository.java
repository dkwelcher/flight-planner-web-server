package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface defining the repository operations for database queries involving country entities.
 *
 * @since 2024-04-23
 */

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity, Long> {

    CountryEntity findCountryEntityByCountryName(String countryName);
    boolean existsByCountryName(String countryName);
}
