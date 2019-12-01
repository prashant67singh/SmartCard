package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TransportRepo extends JpaRepository<Transport, Integer> {

}
