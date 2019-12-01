package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CardTypeRepo extends JpaRepository<CardType, Integer> {
}
