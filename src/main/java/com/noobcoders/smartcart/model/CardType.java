package com.noobcoders.smartcart.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private String cardType;

    private Double multiplyingFactor;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getMultiplyingFactor() {
        return multiplyingFactor;
    }

    public void setMultiplyingFactor(Double multiplyingFactor) {
        this.multiplyingFactor = multiplyingFactor;
    }

    @Override
    public String toString() {
        return "CardType{" +
                "cardId=" + cardId +
                ", cardType='" + cardType + '\'' +
                ", multiplyingFactor=" + multiplyingFactor +
                '}';
    }
}
