package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.Route;
import com.noobcoders.smartcart.model.RoutePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoutePathRepo extends JpaRepository<RoutePath, String> {
    Boolean existsByRouteIdAndStationName(Route routeId, String stationName);
    RoutePath findByRouteIdAndStationName(Route routeId, String stationName);
}
