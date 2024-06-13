package com.kickoffHandsOn.wings1_t4_car_data_api.service;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.CarData;
import org.springframework.http.ResponseEntity;


public interface CarService {

    public ResponseEntity<Object> addCarData(CarData car);
    public ResponseEntity<Object> listAllCarData();
    public ResponseEntity<Object> updateCarData(int id, double price);
    public ResponseEntity<Object> deleteCarData(int id);
}
