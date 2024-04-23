package com.flightplanner.flightplannerserver.loaders;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.services.AircraftService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class AircraftLoader implements CommandLineRunner {

    private static final String AIRCRAFT_FILE = "airplanes.txt";
    private final AircraftService aircraftService;

    public AircraftLoader(AircraftService aircraftService) { this.aircraftService = aircraftService; }

    @Override
    public void run(String... args) throws Exception {
        createAircraft();
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
                aircraftService.save(aircraftDto);
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
