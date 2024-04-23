package com.flightplanner.flightplannerserver.loaders;

import com.flightplanner.flightplannerserver.domain.dto.AirportDto;
import com.flightplanner.flightplannerserver.domain.dto.CountryDto;
import com.flightplanner.flightplannerserver.domain.entities.CountryEntity;
import com.flightplanner.flightplannerserver.mappers.Mapper;
import com.flightplanner.flightplannerserver.repositories.AirportRepository;
import com.flightplanner.flightplannerserver.repositories.CountryRepository;
import com.flightplanner.flightplannerserver.services.AirportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class AirportLoader implements CommandLineRunner {

    private static final String AIRPORT_FILE = "airports.txt";
    private final AirportService airportService;
    private final AirportRepository airportRepository;
    private final CountryRepository countryRepository;
    private final Mapper<CountryEntity, CountryDto> countryMapper;

    public AirportLoader(AirportService airportService, AirportRepository airportRepository, CountryRepository countryRepository, Mapper<CountryEntity, CountryDto> countryMapper) {
        this.airportService = airportService;
        this.airportRepository = airportRepository;
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        createAirports();
    }

    private void createAirports() {

        String line = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(AIRPORT_FILE));
            while((line = bufferedReader.readLine()) != null) {
                AirportDto airportDto = new AirportDto();
                String[] attributes = line.split(",");

                if(!airportRepository.existsByAirportName(attributes[2])) {
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
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
