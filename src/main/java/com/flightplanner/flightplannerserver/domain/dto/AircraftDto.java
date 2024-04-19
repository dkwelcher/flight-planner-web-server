package com.flightplanner.flightplannerserver.domain.dto;

public class AircraftDto {

    private long aircraftId;
    private String aircraftMake;
    private String aircraftModel;
    private String aircraftType;
    private double fuelTankSize; // measured in liters
    private double fuelBurnRate; // measured in liters per hour at cruise speed
    private double airspeed; // measured in knots at cruise speed
    private double maximumRunwayLength; // measured in feet

    public AircraftDto(long aircraftId, String aircraftMake, String aircraftModel, String aircraftType, double fuelTankSize,
                       double fuelBurnRate, double airspeed, double maximumRunwayLength) {
        this.aircraftId = aircraftId;
        this.aircraftMake = aircraftMake;
        this.aircraftModel = aircraftModel;
        this.aircraftType = aircraftType;
        this.fuelTankSize = fuelTankSize;
        this.fuelBurnRate = fuelBurnRate;
        this.airspeed = airspeed;
        this.maximumRunwayLength = maximumRunwayLength;
    }

    public long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAircraftMake() {
        return aircraftMake;
    }

    public void setAircraftMake(String aircraftMake) {
        this.aircraftMake = aircraftMake;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public double getFuelTankSize() {
        return fuelTankSize;
    }

    public void setFuelTankSize(double fuelTankSize) {
        this.fuelTankSize = fuelTankSize;
    }

    public double getFuelBurnRate() {
        return fuelBurnRate;
    }

    public void setFuelBurnRate(double fuelBurnRate) {
        this.fuelBurnRate = fuelBurnRate;
    }

    public double getAirspeed() {
        return airspeed;
    }

    public void setAirspeed(double airspeed) {
        this.airspeed = airspeed;
    }

    public double getMaximumRunwayLength() {
        return maximumRunwayLength;
    }

    public void setMaximumRunwayLength(double maximumRunwayLength) {
        this.maximumRunwayLength = maximumRunwayLength;
    }
}
