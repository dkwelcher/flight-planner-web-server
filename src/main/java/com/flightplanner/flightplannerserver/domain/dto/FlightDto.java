package com.flightplanner.flightplannerserver.domain.dto;

import java.util.List;

public class FlightDto {

    private long flightId;
    private long startingAirportId;
    private long destinationAirportId;
    private long aircraftId;
    private List<FlightLegDto> flightLegs;
    private double totalDistance; // measured in nautical miles
    private double totalDuration; //measured in hours

    public FlightDto(long flightId, long startingAirportId, long destinationAirportId, long aircraftId, List<FlightLegDto> flightLegs, double totalDistance, double totalDuration) {
        this.flightId = flightId;
        this.startingAirportId = startingAirportId;
        this.destinationAirportId = destinationAirportId;
        this.aircraftId = aircraftId;
        this.flightLegs = flightLegs;
        this.totalDistance = totalDistance;
        this.totalDuration = totalDuration;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getStartingAirportId() {
        return startingAirportId;
    }

    public void setStartingAirportId(long startingAirportId) {
        this.startingAirportId = startingAirportId;
    }

    public long getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(long destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public List<FlightLegDto> getFlightLegs() {
        return flightLegs;
    }

    public void setFlightLegs(List<FlightLegDto> flightLegs) {
        this.flightLegs = flightLegs;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }
}
