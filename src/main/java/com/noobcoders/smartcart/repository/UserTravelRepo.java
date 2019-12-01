package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.User;
import com.noobcoders.smartcart.model.UserTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserTravelRepo extends JpaRepository<UserTravel, Integer> {
    Boolean existsByUser(User user);
    UserTravel findByUser(User user);

}
