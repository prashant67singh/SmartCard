package com.noobcoders.smartcart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String rfid;

    private String name;

    @OneToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CardType cardId;

    @JsonIgnore
    private String password;

    private Double currentBalance;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getCardId() {
        return cardId;
    }

    public void setCardId(CardType cardId) {
        this.cardId = cardId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "User{" +
                "rfid=" + rfid +
                ", name='" + name + '\'' +
                ", cardId=" + cardId +
                ", password='" + password + '\'' +
                ", currentBalance=" + currentBalance +
                '}';
    }
}