package com.noobcoders.smartcart.services;

import com.noobcoders.smartcart.model.Recharge;
import com.noobcoders.smartcart.model.User;
import com.noobcoders.smartcart.model.input.RechargeAdd;
import com.noobcoders.smartcart.repository.RechargeRepo;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class RechargeService {

    private final RechargeRepo rechargeRepo;
    private final UserService userServices;
    private final Calendar calendar;

    public RechargeService(RechargeRepo rechargeRepo, UserService userService) {
        this.rechargeRepo = rechargeRepo;
        this.userServices = userService;
        this.calendar = Calendar.getInstance();
    }

    // Services
    public Recharge getReceiptDetails(Integer receiptId) {
        return rechargeRepo.findById(receiptId).orElse(null);
    }

    public List<Recharge> getUserReceiptsList(User userId) {
        return rechargeRepo.getRechargesByUserId(userId);
    }

    public List<Recharge> getReceiptListOfCurrentMonth(User user) {
        int currMonth = calendar.get(Calendar.MONTH)+1;
        return rechargeRepo.getRechargeListOfUserInMonth(user, currMonth);
    }

    public Recharge convertToRecharge(RechargeAdd rechargeAdd, String userId) {
        return new Recharge(rechargeAdd.getPayMode(),
                rechargeAdd.getRechargePoint(),
                rechargeAdd.getRechargeAmount(),
                userServices.getUserInfo(userId));
    }

    public void addReceipt(Recharge recharge) {
        rechargeRepo.save(recharge);
    }

    // Validation
    public boolean validId(Integer receiptId) {
        return rechargeRepo.existsById(receiptId);
    }



}
