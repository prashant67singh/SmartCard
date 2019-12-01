package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepo extends JpaRepository<User, String> {
    List<User> getUsersByRfidAndPassword(String rfid, String password);

    @Modifying(clearAutomatically = true)
    @Query("update User set currentBalance = currentBalance + ?2 where rfid = ?1")
    void updateUserBalance(String userId, Double balance);
}
