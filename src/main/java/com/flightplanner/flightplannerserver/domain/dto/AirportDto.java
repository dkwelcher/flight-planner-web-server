package com.flightplanner.flightplannerserver.domain.dto;

public class AirportDto {

    private long airportId;
    private String icao;
    private String airportName;
    private String continent;
    private String country;
    private String stateOrRegion;
    private double latitude;
    private double longitude;
    private boolean isJetAAvailable;
    private boolean isAvgasAvailable;
    private double minimumRunwayLengthRequired;

    public AirportDto(long airportId, String icao, String airportName, String continent, String country, String stateOrRegion,
                      double latitude, double longitude, boolean isJetAAvailable, boolean isAvgasAvailable, double minimumRunwayLengthRequired) {

        this.airportId = airportId;
        this.icao = icao;
        this.airportName = airportName;
        this.continent = continent;
        this.country = country;
        this.stateOrRegion = stateOrRegion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isJetAAvailable = isJetAAvailable;
        this.isAvgasAvailable = isAvgasAvailable;
        this.minimumRunwayLengthRequired = minimumRunwayLengthRequired;
    }

    public long getAirportId() {
        return airportId;
    }

    public void setAirportId(long airportId) {
        this.airportId = airportId;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateOrRegion() {
        return stateOrRegion;
    }

    public void setStateOrRegion(String stateOrRegion) {
        this.stateOrRegion = stateOrRegion;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isJetAAvailable() {
        return isJetAAvailable;
    }

    public void setJetAAvailable(boolean jetAAvailable) {
        isJetAAvailable = jetAAvailable;
    }

    public boolean isAvgasAvailable() {
        return isAvgasAvailable;
    }

    public void setAvgasAvailable(boolean avgasAvailable) {
        isAvgasAvailable = avgasAvailable;
    }

    public double getMinimumRunwayLengthRequired() {
        return minimumRunwayLengthRequired;
    }

    public void setMinimumRunwayLengthRequired(double minimumRunwayLengthRequired) {
        this.minimumRunwayLengthRequired = minimumRunwayLengthRequired;
    }
}
