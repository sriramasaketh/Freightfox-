package com.example.distanceapi.service;

import com.example.distanceapi.entity.DistanceEntity;
import com.example.distanceapi.repository.DistanceRepository;
import com.example.distanceapi.dto.GoogleMapsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    @Autowired
    private DistanceRepository distanceRepository;

    @Autowired
    private GoogleMapsService googleMapsService;

    @Cacheable(value = "distances", key = "#fromPincode + #toPincode")
    public DistanceEntity getDistance(String fromPincode, String toPincode) {
        return distanceRepository.findByFromPincodeAndToPincode(fromPincode, toPincode)
                .orElseGet(() -> fetchAndSaveDistance(fromPincode, toPincode));
    }

    private DistanceEntity fetchAndSaveDistance(String fromPincode, String toPincode) {
        GoogleMapsResponse response = googleMapsService.getDistanceBetweenPincodes(fromPincode, toPincode);

        DistanceEntity entity = new DistanceEntity();
        entity.setFromPincode(fromPincode);
        entity.setToPincode(toPincode);
        entity.setDistance(response.getDistance());
        entity.setDuration(response.getDuration());
        entity.setRoute(response.getRoute());

        return distanceRepository.save(entity);
    }
}
