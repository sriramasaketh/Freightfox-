package com.example.distanceapi.service;

import com.example.distanceapi.dto.GoogleMapsResponse;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapsService {

    @Value("${google.maps.api.key}")
    private String apiKey;

    public GoogleMapsResponse getDistanceBetweenPincodes(String fromPincode, String toPincode) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        try {
            DirectionsResult result = DirectionsApi.getDirections(context, fromPincode, toPincode).await();
            DirectionsRoute route = result.routes[0];
            DirectionsLeg leg = route.legs[0];

            return new GoogleMapsResponse(
                    leg.distance.inMeters / 1000.0,
                    leg.duration.humanReadable,
                    route.overviewPolyline.getEncodedPath());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching route from Google Maps API", e);
        }
    }
}
