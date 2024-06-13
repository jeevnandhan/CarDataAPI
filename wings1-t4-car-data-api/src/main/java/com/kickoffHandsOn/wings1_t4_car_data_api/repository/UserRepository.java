package com.kickoffHandsOn.wings1_t4_car_data_api.repository;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Integer> {
    
    List<UserDetail> findByusername(String username);
}
