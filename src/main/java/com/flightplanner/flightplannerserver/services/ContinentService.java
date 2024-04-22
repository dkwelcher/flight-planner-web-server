package com.flightplanner.flightplannerserver.services;

import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;

import java.util.Optional;

public interface ContinentService {

    void save(ContinentDto continentDto);
}
