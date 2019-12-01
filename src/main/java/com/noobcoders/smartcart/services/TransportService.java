package com.noobcoders.smartcart.services;

import com.noobcoders.smartcart.model.*;
import com.noobcoders.smartcart.model.input.TravelAdd;
import com.noobcoders.smartcart.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
public class TransportService {

    private final UserTravelHistoryRepo travelHistoryRepo;
    private final TransportRepo transportRepo;
    private final UserRepo userRepo;
    private final UserTravelRepo userTravelRepo;
    private final RoutePathRepo routePathRepo;

    public TransportService(UserTravelHistoryRepo travelHistoryRepo, TransportRepo transportRepo, UserRepo userRepo, UserTravelRepo userTravelRepo, RoutePathRepo routePathRepo) {
        this.travelHistoryRepo = travelHistoryRepo;
        this.transportRepo = transportRepo;
        this.userRepo = userRepo;
        this.userTravelRepo = userTravelRepo;
        this.routePathRepo = routePathRepo;
    }


    // Services
    public UserTravelHistory getPastTravelDetails(Integer id) {
        return travelHistoryRepo.findById(id).orElse(null);
    }

    public List<UserTravelHistory> getUserTravelList(String userId) {
        return travelHistoryRepo.getAllByUserId(userRepo.findById(userId).orElse(null));
    }


    // Validation
    public boolean validUserTravelHistoryId(Integer id) {
        return travelHistoryRepo.existsById(id);
    }

    public boolean validTransportId(Integer transportId) {
        return transportRepo.existsById(transportId);
    }

    public boolean isStartingTravel(User user) {
        return !userTravelRepo.existsByUser(user);
    }

    public UserTravel convertToUserTravel(TravelAdd travelAdd, User user) {
        return new UserTravel(travelAdd.getStationName(), transportRepo.findById(travelAdd.getTransportId()).orElse(null), user);
    }

    public String startTravel(UserTravel startTravel) {
        Route route = startTravel.getTransportId().getRoute();
        if(!routePathRepo.existsByRouteIdAndStationName(route, startTravel.getStationName()))
            return "Source Station is Not in Route Path";
        userTravelRepo.save(startTravel);
        return "Journey Started for " + startTravel.getUser().getName();
    }

    @Transactional
    public ResponseEntity<String> endTravel(UserTravel endTravel) {
        Transport transport = endTravel.getTransportId();
        User user = endTravel.getUser();
        Route route = transport.getRoute();
        if(!routePathRepo.existsByRouteIdAndStationName(route, endTravel.getStationName()))
            return new ResponseEntity<>("Destination Station is Not in Route Path", HttpStatus.BAD_REQUEST);

        UserTravel startTravel = userTravelRepo.findByUser(endTravel.getUser());

        if(!transport.getTransportId().equals(startTravel.getTransportId().getTransportId()))
            return new ResponseEntity<>("Transportation is not Same", HttpStatus.BAD_REQUEST);

        RoutePath sourceStation = routePathRepo.findByRouteIdAndStationName(startTravel.getTransportId().getRoute(),startTravel.getStationName());
        RoutePath destinationStation = routePathRepo.findByRouteIdAndStationName(endTravel.getTransportId().getRoute(), endTravel.getStationName());

        float distance = Math.abs(sourceStation.getAccumulativeDistance() - destinationStation.getAccumulativeDistance());
        double fare = distance * transport.getTransportationMode().getRate() * user.getCardId().getMultiplyingFactor();

        UserTravelHistory history = new UserTravelHistory();
        history.setUserId(endTravel.getUser());
        history.setStartStation(startTravel.getStationName());
        history.setEndStation(endTravel.getStationName());
        history.setTransportId(startTravel.getTransportId());
        history.setTravelStartDate(startTravel.getCreatedAt());
        history.setTravelEndDate(new Date());
        history.setFare(fare);
        history.setDistance(distance);

        travelHistoryRepo.save(history);
        userTravelRepo.delete(startTravel);

        return new ResponseEntity<>("Journey Ended For " + endTravel.getUser().getName(), HttpStatus.OK);
    }
}
