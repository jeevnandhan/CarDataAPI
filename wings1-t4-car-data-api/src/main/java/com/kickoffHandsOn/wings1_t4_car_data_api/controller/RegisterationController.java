package com.kickoffHandsOn.wings1_t4_car_data_api.controller;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.UserDetail;
import com.kickoffHandsOn.wings1_t4_car_data_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carData")
public class RegisterationController {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDetail userDetail){

        ResponseEntity response = null;
        try{

            String hashedPassword = passwordEncoder.encode(userDetail.getPassword());
            userDetail.setPassword(hashedPassword);
            UserDetail savedUser = userRepository.save(userDetail);
            if(savedUser.getUserId()>0){
                response= ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
            }
        } catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An Exception occured due to "+ e.getMessage());
        }
        return response;
    }

}
