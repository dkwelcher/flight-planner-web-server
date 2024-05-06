package com.flightplanner.flightplannerserver.loaders;


import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.domain.dto.AirportDto;
import com.flightplanner.flightplannerserver.domain.dto.ContinentDto;
import com.flightplanner.flightplannerserver.domain.dto.CountryDto;
import com.flightplanner.flightplannerserver.domain.entities.ContinentEntity;
import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import com.flightplanner.flightplannerserver.repositories.AircraftRepository;
import com.flightplanner.flightplannerserver.repositories.AirportRepository;
import com.flightplanner.flightplannerserver.repositories.ContinentRepository;
import com.flightplanner.flightplannerserver.repositories.CountryRepository;
import com.flightplanner.flightplannerserver.services.AircraftService;
import com.flightplanner.flightplannerserver.services.AirportService;
import com.flightplanner.flightplannerserver.services.ContinentService;
import com.flightplanner.flightplannerserver.services.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Loader class for populating database. For development only.
 * Populates database with all continents and countries.
 * Populates database with 128 airports around the world and several aircraft for testing purposes.
 *
 * Loader methods are consolidated to avoid errors by controlling order of database population.
 *
 * @since 2024-05-06
 */

@Slf4j
@Component
public class DatabaseLoader implements CommandLineRunner {

    private static final String AIRCRAFT_FILE = "airplanes.txt";
    private static final String AIRPORT_FILE = "airports.txt";

    private final ContinentService continentService;
    private final CountryService countryService;
    private final CountryRepository countryRepository;
    private final ContinentRepository continentRepository;
    private final Mapper<ContinentEntity, ContinentDto> continentMapper;
    private final AircraftService aircraftService;
    private final AircraftRepository aircraftRepository;
    private final AirportService airportService;
    private final AirportRepository airportRepository;
    private final Mapper<CountryEntity, CountryDto> countryMapper;

    public DatabaseLoader(ContinentService continentService,
                          CountryService countryService,
                          CountryRepository countryRepository,
                          ContinentRepository continentRepository,
                          Mapper<ContinentEntity, ContinentDto> continentMapper,
                          AircraftService aircraftService,
                          AircraftRepository aircraftRepository,
                          AirportService airportService,
                          AirportRepository airportRepository,
                          Mapper<CountryEntity, CountryDto> countryMapper) {

        this.continentService = continentService;
        this.countryService = countryService;
        this.countryRepository = countryRepository;
        this.continentRepository = continentRepository;
        this.continentMapper = continentMapper;
        this.aircraftService = aircraftService;
        this.aircraftRepository = aircraftRepository;
        this.airportService = airportService;
        this.airportRepository = airportRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        createContinents();
        createCountries();
        createAircraft();
        createAirports();
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
            if(!continentRepository.existsByContinentName(continentDto.getContinentName())) {
                continentService.save(continentDto);
            }
        }
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
                        .continent(continentDto)
                        .build();
                countryService.save(countryDto);
            }
        }
    }

    private void createAircraft() {

        String line = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(AIRCRAFT_FILE));
            while((line = bufferedReader.readLine()) != null) {
                AircraftDto aircraftDto = new AircraftDto();
                String[] attributes = line.split(",");
                aircraftDto.setAircraftId(Long.parseLong(attributes[0]));
                aircraftDto.setAircraftMake(attributes[1]);
                aircraftDto.setAircraftModel(attributes[2]);
                aircraftDto.setAircraftType(attributes[3]);
                aircraftDto.setFuelType(attributes[4]);
                aircraftDto.setFuelTankSize(Double.parseDouble(attributes[5]));
                aircraftDto.setFuelBurnRate(Double.parseDouble(attributes[6]));
                aircraftDto.setAirspeed(Double.parseDouble(attributes[7]));
                aircraftDto.setMinimumRunwayLengthRequired(Double.parseDouble(attributes[8]));
                if(!aircraftRepository.existsByAircraftMakeAndAircraftModel(aircraftDto.getAircraftMake(), aircraftDto.getAircraftModel())) {
                    aircraftService.save(aircraftDto);
                }
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            log.error("Aircraft file not found", e);
        } catch(IOException e) {
            log.error("IO Exception occurred while trying to read aircraft file", e);
        }
    }

    private void createAirports() {

        String line = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(AIRPORT_FILE));
            while((line = bufferedReader.readLine()) != null) {
                AirportDto airportDto = new AirportDto();
                String[] attributes = line.split(",");

                if(!airportRepository.existsByIcao(attributes[1])) {
                    airportDto.setAirportId(Long.parseLong(attributes[0]));
                    airportDto.setIcao(attributes[1]);
                    airportDto.setAirportName(attributes[2]);

                    String countryName = attributes[3];
                    CountryEntity countryEntity = countryRepository.findCountryEntityByCountryName(countryName);
                    CountryDto countryDto = countryMapper.mapTo(countryEntity);
                    airportDto.setCountry(countryDto);

                    airportDto.setLatitude(Double.parseDouble(attributes[4]));
                    airportDto.setLongitude(Double.parseDouble(attributes[5]));
                    airportDto.setMaximumRunwayLength(Double.parseDouble(attributes[6]));
                    airportDto.setAvgasAvailable(Boolean.parseBoolean(attributes[7]));
                    airportDto.setJetaAvailable(Boolean.parseBoolean(attributes[8]));
                    airportService.save(airportDto);
                }
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            log.error("Airports file not found", e);
        } catch(IOException e) {
            log.error("IO Exception occurred while trying to read airports file", e);
        }
    }
}
