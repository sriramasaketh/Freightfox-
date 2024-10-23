package com.example.distanceapi.controller;

import com.example.distanceapi.entity.DistanceEntity;
import com.example.distanceapi.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/distances")
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    @GetMapping
    public ResponseEntity<DistanceEntity> getDistance(
            @RequestParam String fromPincode,
            @RequestParam String toPincode) {
        DistanceEntity distance = distanceService.getDistance(fromPincode, toPincode);
        return ResponseEntity.ok(distance);
    }
}
