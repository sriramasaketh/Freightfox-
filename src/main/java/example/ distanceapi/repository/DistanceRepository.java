package com.example.distanceapi.repository;

import com.example.distanceapi.entity.DistanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DistanceRepository extends JpaRepository<DistanceEntity, Long> {
    Optional<DistanceEntity> findByFromPincodeAndToPincode(String fromPincode, String toPincode);
}
