package com.kickoffHandsOn.wings1_t4_car_data_api.controller;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.CarData;
import com.kickoffHandsOn.wings1_t4_car_data_api.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carData")
public class CarDataController {

    @Autowired
    private CarService carService;
    @PostMapping("/add")
    public ResponseEntity<Object> postCarData(@RequestBody CarData carData){
        return carService.addCarData(carData);
    }
    @GetMapping("/list")
    public ResponseEntity<Object> listAllCarData(){
        return carService.listAllCarData();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCarData(@PathVariable int id, @RequestBody CarData carData){


            if(carData == null){
                return new ResponseEntity<>("No Data Provided", HttpStatus.BAD_REQUEST);
            }
            double price = carData.getPrice();
            return carService.updateCarData(id,price);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCarData(@PathVariable int id){
        return carService.deleteCarData(id);
    }
}
