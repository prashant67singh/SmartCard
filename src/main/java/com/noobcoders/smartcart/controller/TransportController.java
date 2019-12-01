package com.noobcoders.smartcart.controller;

import com.noobcoders.smartcart.model.User;
import com.noobcoders.smartcart.model.input.TravelAdd;
import com.noobcoders.smartcart.services.TransportService;
import com.noobcoders.smartcart.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transport")
public class TransportController {

    private final TransportService transportService;
    private final UserService userService;

    public TransportController(TransportService transportService, UserService userService) {
        this.transportService = transportService;
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getPastTravelInfo(@PathVariable Integer id) {
        if (!transportService.validUserTravelHistoryId(id))
            return new ResponseEntity<>("Invalid Travel History ID", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(transportService.getPastTravelDetails(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserTraveledDetails(@PathVariable String userId) {
        if (!userService.validId(userId))
            return new ResponseEntity<>("Invalid User ID", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(transportService.getUserTravelList(userId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{userId}")
    public ResponseEntity<String> userTravelOperations(@Valid @RequestBody TravelAdd travelAdd, @PathVariable String userId) {
        if (!userService.validId(userId))
            return new ResponseEntity<>("Invalid User ID", HttpStatus.BAD_REQUEST);
        if (!transportService.validTransportId(travelAdd.getTransportId()))
            return new ResponseEntity<>("Invalid Transport ID", HttpStatus.BAD_REQUEST);
        User user = userService.getUserInfo(userId);
        if (transportService.isStartingTravel(user))
            return new ResponseEntity<>(transportService.startTravel(transportService.convertToUserTravel(travelAdd, user)), HttpStatus.OK);
        else {
            return transportService.endTravel(transportService.convertToUserTravel(travelAdd, user));
        }
    }
}
