package com.noobcoders.smartcart.model.input;

public class RechargeAdd {
    private String payMode;
    private Double rechargeAmount;
    private String rechargePoint;

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

}
