package com.noobcoders.smartcart.controller;

import com.noobcoders.smartcart.model.input.RechargeAdd;
import com.noobcoders.smartcart.services.RechargeService;
import com.noobcoders.smartcart.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/recharge")
public class RechargeController {

    private final RechargeService rechargeService;
    private final UserService userServices;

    public RechargeController(RechargeService rechargeService, UserService userService) {
        this.rechargeService = rechargeService;
        this.userServices = userService;
    }

    @GetMapping("{receiptId}")
    public ResponseEntity<Object> getReceiptInfo(@PathVariable Integer receiptId) {
        if(rechargeService.validId(receiptId))
            return new ResponseEntity<>(rechargeService.getReceiptDetails(receiptId), HttpStatus.OK);
        else
            return new ResponseEntity<>("Invalid Receipt ID", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserReceipts(@PathVariable String userId){
        if(userServices.validId(userId))
            return new ResponseEntity<>(rechargeService.getUserReceiptsList(userServices.getUserInfo(userId)), HttpStatus.OK);
        else
            return new ResponseEntity<>("Not a Valid User Id", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/user/{userId}/current")
    public ResponseEntity<Object> getUserReceiptsOfCurrentMonth(@PathVariable String userId){
        if(userServices.validId(userId))
            return new ResponseEntity<>(rechargeService.getReceiptListOfCurrentMonth(userServices.getUserInfo(userId)),HttpStatus.OK);
        else
            return new ResponseEntity<>("Not a Valid User Id", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping("{userId}")
    public ResponseEntity<Object> addRecharge(@RequestBody RechargeAdd rechargeAdd, @PathVariable String userId){
        if(userServices.validId(userId)) {
            userServices.updateUserBalance(userId, rechargeAdd.getRechargeAmount());
            rechargeService.addReceipt(rechargeService.convertToRecharge(rechargeAdd, userId));
            return new ResponseEntity<>("Recharge Data Saved", HttpStatus.OK);
        }else
            return new ResponseEntity<>("Not a Valid User Id", HttpStatus.BAD_REQUEST);
    }
}
