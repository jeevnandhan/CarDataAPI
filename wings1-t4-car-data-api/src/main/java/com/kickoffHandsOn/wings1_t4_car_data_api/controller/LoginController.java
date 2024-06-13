package com.kickoffHandsOn.wings1_t4_car_data_api.controller;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.UserDetail;
import com.kickoffHandsOn.wings1_t4_car_data_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    public UserRepository userRepository;
    @RequestMapping("/carData/user")
    public UserDetail getUserDetailsAfterLogin(Authentication authentication){
        List<UserDetail> customers = userRepository.findByusername(authentication.getName());
        if(!customers.isEmpty()){
            return customers.get(0);
        } else{
            return null;
        }
    }
}
