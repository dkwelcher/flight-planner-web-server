package com.flightplanner.flightplannerserver.repositories;

import com.flightplanner.flightplannerserver.domain.dto.CountryDto;
import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity, Long> {

    CountryEntity findCountryEntityByCountryName(String countryName);
    boolean existsByCountryName(String countryName);
}
