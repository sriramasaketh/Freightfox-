package com.example.distanceapi.dto;

public class GoogleMapsResponse {
    private double distance;
    private String duration;
    private String route;

    public GoogleMapsResponse(double distance, String duration, String route) {
        this.distance = distance;
        this.duration = duration;
        this.route = route;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
