package com.kickoffHandsOn.wings1_t4_car_data_api.repository;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.CarData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarData, Integer> {
}
