package com.flightplanner.flightplannerserver.domain.dto;

public class FlightLegDto {

    private long flightLegId;
    private long flightId;
    private long startingAirportId;
    private long destinationAirportId;
    private int flightLegNumber;
    private double distance; // measured in nautical miles
    private double duration; // measure in hours
    private String cardinalDirection;

    public FlightLegDto(long flightLegId, long flightId, long startingAirportId, long destinationAirportId, int flightLegNumber, double distance, double duration, String cardinalDirection) {
        this.flightLegId = flightLegId;
        this.flightId = flightId;
        this.startingAirportId = startingAirportId;
        this.destinationAirportId = destinationAirportId;
        this.flightLegNumber = flightLegNumber;
        this.distance = distance;
        this.duration = duration;
        this.cardinalDirection = cardinalDirection;
    }

    public long getFlightLegId() {
        return flightLegId;
    }

    public void setFlightLegId(long flightLegId) {
        this.flightLegId = flightLegId;
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

    public int getFlightLegNumber() {
        return flightLegNumber;
    }

    public void setFlightLegNumber(int flightLegNumber) {
        this.flightLegNumber = flightLegNumber;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getCardinalDirection() {
        return cardinalDirection;
    }

    public void setCardinalDirection(String cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }
}
