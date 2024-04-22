package com.flightplanner.flightplannerserver.loaders;

import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;
import com.flightplanner.flightplannerserver.domain.dto.CountryDto;
import com.flightplanner.flightplannerserver.domain.entities.ContinentEntity;
import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import com.flightplanner.flightplannerserver.mappers.impl.ContinentMapperImpl;
import com.flightplanner.flightplannerserver.repositories.ContinentRepository;
import com.flightplanner.flightplannerserver.repositories.CountryRepository;
import com.flightplanner.flightplannerserver.services.CountryService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryLoader implements CommandLineRunner {

    private final CountryService countryService;

    private final CountryRepository countryRepository;

    private final ContinentRepository continentRepository;

    private final Mapper<ContinentEntity, ContinentDto> continentMapper;

    public CountryLoader(CountryService countryService, CountryRepository countryRepository, ContinentRepository continentRepository, Mapper<ContinentEntity, ContinentDto> continentMapper) {
        this.countryService = countryService;
        this.countryRepository = countryRepository;
        this.continentRepository = continentRepository;
        this.continentMapper = continentMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        createCountries();
    }

    private void createCountries() {

        final String url = "https://restcountries.com/v3.1/all?fields=name,continents";
        RestTemplate restTemplate = new RestTemplate();
        JSONArray countries = new JSONArray(restTemplate.getForObject(url, String.class));

        for(int i = 0; i < countries.length(); ++i) {
            JSONObject country = countries.getJSONObject(i);
            String countryName = country.getJSONObject("name").getString("common");
            JSONArray continents = country.getJSONArray("continents");

            String continentName = continents.getString(0);
            if(continentName.equals("Oceania")) {
                continentName = "Australia";
            }

            if(!countryRepository.existsByCountryName(countryName)) {
                ContinentEntity continentEntity = continentRepository.findByContinentName(continentName);
                if (continentEntity == null) {
                    System.err.println("Continent not found for " + continents.getString(0) + ". Cannot create country: " + countryName);
                    continue;
                }

                if (continentEntity.getContinentName().equals("Oceania")) {
                    continentEntity.setContinentName("Australia");
                }

                ContinentDto continentDto = continentMapper.mapTo(continentEntity);

                if (continentDto.getContinentName().equals("Oceania")) {
                    continentDto.setContinentName("Australia");
                }

                CountryDto countryDto = CountryDto.builder()
                        .countryName(countryName)
                        .continentDto(continentDto)
                        .build();
                countryService.save(countryDto);
            }
        }
    }
}
