package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RouteRepo extends JpaRepository<Route, Integer> {

}
