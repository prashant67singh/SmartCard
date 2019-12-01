package com.noobcoders.smartcart.controller;

import com.noobcoders.smartcart.model.input.UserLogin;
import com.noobcoders.smartcart.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userServices;

    public UserController(UserService userServices) {
        this.userServices = userServices;
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getUserDetails(@PathVariable("id") String id) {
        if (!userServices.validId(id))
            return new ResponseEntity<>("Invalid Details", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userServices.getUserInfo(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("")
    public ResponseEntity<Object> verifyUserLogin(@Valid @RequestBody UserLogin userLogin) {
        if(userLogin == null)
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        if(userServices.isValidUserDetails(userLogin))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

}
