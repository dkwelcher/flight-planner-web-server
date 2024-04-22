package com.flightplanner.flightplannerserver.loaders;

import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;
import com.flightplanner.flightplannerserver.services.ContinentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ContinentLoader implements CommandLineRunner {

    private final ContinentService continentService;

    public ContinentLoader(ContinentService continentService) {
        this.continentService = continentService;
    }

    @Override
    public void run(String... args) throws Exception {
        createContinents();
    }

    private void createContinents() {
        ContinentDto[] continentDtos = {
                new ContinentDto(1, "Africa"),
                new ContinentDto(2, "Antarctica"),
                new ContinentDto(3, "Asia"),
                new ContinentDto(4, "Australia"),
                new ContinentDto(5, "Europe"),
                new ContinentDto(6, "North America"),
                new ContinentDto(7, "South America")
        };

        for (ContinentDto continentDto : continentDtos) {
            continentService.save(continentDto);
        }
    }
}

