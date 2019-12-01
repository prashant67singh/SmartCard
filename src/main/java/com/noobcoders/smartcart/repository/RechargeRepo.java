package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.Recharge;
import com.noobcoders.smartcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RechargeRepo extends JpaRepository<Recharge, Integer> {
    List<Recharge> getRechargesByUserId(User userId);

    @Query("FROM Recharge WHERE MONTH(recharge_timestamp) = ?1")
    List<Recharge> getAllRechargeListInMonth(int rechargeTimestamp_month);

    @Query("FROM Recharge WHERE MONTH(recharge_timestamp) = ?2 AND user_id = ?1")
    List<Recharge> getRechargeListOfUserInMonth(User user, int month);
}
