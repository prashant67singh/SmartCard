package com.noobcoders.smartcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receiptNo;

    private String payMode;
    private Double rechargeAmount;
    private String rechargePoint;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @CreationTimestamp
    private Date rechargeTimestamp;

    public Recharge() { }

    public Recharge(String payMode, String rechargePoint, Double rechargeAmount, User userInfo) {
        this.payMode = payMode;
        this.rechargePoint = rechargePoint;
        this.rechargeAmount = rechargeAmount;
        this.userId = userInfo;
    }

    public Integer getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(Integer receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public Double getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getRechargePoint() {
        return rechargePoint;
    }

    public void setRechargePoint(String rechargePoint) {
        this.rechargePoint = rechargePoint;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getRechargeTimestamp() {
        return rechargeTimestamp;
    }

    public void setRechargeTimestamp(Date rechargeTimestamp) {
        this.rechargeTimestamp = rechargeTimestamp;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "receiptNo=" + receiptNo +
                ", payMode='" + payMode + '\'' +
                ", rechargeAmount=" + rechargeAmount +
                ", rechargePoint='" + rechargePoint + '\'' +
                ", userId=" + userId +
                ", rechargeTimestamp=" + rechargeTimestamp +
                '}';
    }
}
