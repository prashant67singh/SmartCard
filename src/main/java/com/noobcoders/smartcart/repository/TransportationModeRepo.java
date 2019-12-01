package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.TransportationMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TransportationModeRepo extends JpaRepository<TransportationMode, Integer> {
}
