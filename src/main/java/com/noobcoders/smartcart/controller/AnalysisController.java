package com.noobcoders.smartcart.controller;

import com.noobcoders.smartcart.model.User;
import com.noobcoders.smartcart.services.AnalysisService;
import com.noobcoders.smartcart.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;
    private final UserService userService;

    public AnalysisController(AnalysisService analysisService, UserService userService) {
        this.analysisService = analysisService;
        this.userService = userService;
    }

    @GetMapping("/{num}")
    public ResponseEntity<Object> getAnalysis(@PathVariable Integer num) {
        switch (num) {
            case 1:
                return new ResponseEntity<>(analysisService.getAnalysis1(), HttpStatus.OK);
            case 2:
                return new ResponseEntity<>(analysisService.getAnalysis2(), HttpStatus.OK);
            case 3:
                return new ResponseEntity<>(analysisService.getAnalysis3(), HttpStatus.OK);
            default:
                return new ResponseEntity<>("Invalid Analysis Number", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{num}/{userId}")
    public ResponseEntity<Object> getAnalysisUser(@PathVariable String userId, @PathVariable Integer num) {
        if (!userService.validId(userId))
            return new ResponseEntity<>("User Id Invalid", HttpStatus.BAD_REQUEST);
        User user = userService.getUserInfo(userId);
        switch (num) {
            case 1:
                return new ResponseEntity<>(analysisService.getAnalysis1(user), HttpStatus.OK);
            case 2:
                return new ResponseEntity<>(analysisService.getAnalysis2(user), HttpStatus.OK);
            case 3:
                return new ResponseEntity<>(analysisService.getAnalysis3(user), HttpStatus.OK);
            default:
                return new ResponseEntity<>("Invalid Analysis Number", HttpStatus.BAD_REQUEST);
        }
    }

}
