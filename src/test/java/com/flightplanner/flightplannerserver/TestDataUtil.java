package com.flightplanner.flightplannerserver;

import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static AircraftDto createTestValidAircraftDtoA() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("A320")
                .aircraftType("jet")
                .fuelType("jeta")
                .fuelTankSize(27200.0)
                .fuelBurnRate(3648.14)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoEmptyAircraftMake() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("")
                .aircraftModel("A320")
                .aircraftType("jet")
                .fuelType("jeta")
                .fuelTankSize(27200.0)
                .fuelBurnRate(3648.14)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoEmptyAircraftModel() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("")
                .aircraftType("jet")
                .fuelType("jeta")
                .fuelTankSize(27200.0)
                .fuelBurnRate(3648.14)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoEmptyAircraftType() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("A320")
                .aircraftType("")
                .fuelType("jeta")
                .fuelTankSize(27200.0)
                .fuelBurnRate(3648.14)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoEmptyFuelType() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("A320")
                .aircraftType("jet")
                .fuelType("")
                .fuelTankSize(27200.0)
                .fuelBurnRate(3648.14)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoNullFuelTankSize() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("A320")
                .aircraftType("jet")
                .fuelType("jeta")
                .fuelTankSize(null)
                .fuelBurnRate(3648.14)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoNullFuelBurnRate() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("A320")
                .aircraftType("jet")
                .fuelType("jeta")
                .fuelTankSize(27200.0)
                .fuelBurnRate(null)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoNullAirspeed() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("A320")
                .aircraftType("jet")
                .fuelType("jeta")
                .fuelTankSize(27200.0)
                .fuelBurnRate(3648.14)
                .airspeed(null)
                .range(null)
                .minimumRunwayLengthRequired(5900.0)
                .build();
    }

    public static AircraftDto createTestInvalidAircraftDtoNullMinimumRunwayLengthRequired() {
        return AircraftDto.builder()
                .aircraftId(null)
                .aircraftMake("Airbus")
                .aircraftModel("A320")
                .aircraftType("jet")
                .fuelType("jeta")
                .fuelTankSize(27200.0)
                .fuelBurnRate(3648.14)
                .airspeed(450.0)
                .range(null)
                .minimumRunwayLengthRequired(null)
                .build();
    }
}
