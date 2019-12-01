package com.noobcoders.smartcart.services;

import com.noobcoders.smartcart.model.User;
import com.noobcoders.smartcart.model.input.UserLogin;
import com.noobcoders.smartcart.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class UserService {

    private final UserRepo userRepo;

    public UserService(@Autowired UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Services
    public User getUserInfo(String id) {
        return userRepo.findById(id).orElse(null);
    }

    public void updateUserBalance(String userId, Double balance){
        userRepo.updateUserBalance(userId,balance);
    }

    // Validations
    public boolean validId(String id) {
        return userRepo.existsById(id);
    }

    public boolean isValidUserDetails(@Valid UserLogin userLogin) {
        return userRepo.getUsersByRfidAndPassword(userLogin.getRfid(), userLogin.getPassword()).size() == 1;
    }
}
