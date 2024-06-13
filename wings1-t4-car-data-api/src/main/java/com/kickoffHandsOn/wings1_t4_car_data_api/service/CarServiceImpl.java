package com.kickoffHandsOn.wings1_t4_car_data_api.service;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.CarData;
import com.kickoffHandsOn.wings1_t4_car_data_api.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public ResponseEntity<Object> addCarData(CarData carData) {
        try{
            CarData newCarData = new CarData(
                    carData.getModel(),
                    carData.getManufacturedYear(),
                    carData.getCompany(),
                    carData.getBodyType(),
                    carData.getPrice(),
                    carData.getFuelType(),
                    carData.getSeatingCapacity()
            );

            carRepository.save(newCarData);
            return new ResponseEntity<>(newCarData, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> listAllCarData() {

        List<CarData> carDataList = carRepository.findAll();
        if(!carDataList.isEmpty()){
            return new ResponseEntity<>(carDataList,HttpStatus.OK);
        } else{
            return new ResponseEntity<>("No Data Available", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateCarData(int id, double price) {
            Optional<CarData> carDataOptional = carRepository.findById(id);
            if(carDataOptional.isEmpty()){
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            } else{
                CarData carData = carDataOptional.get();
                carData.setPrice(price);
                carRepository.save(carData);
                return new ResponseEntity<>(carData, HttpStatus.OK);
            }

    }

    @Override
    public ResponseEntity<Object> deleteCarData(int id) {

        if(carRepository.existsById(id)){
            Optional<CarData> carDataOptional = carRepository.findById(id);
            CarData carData = carDataOptional.get();
            carRepository.delete(carData);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
