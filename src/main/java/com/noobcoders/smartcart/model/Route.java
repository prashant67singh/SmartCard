package com.noobcoders.smartcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {
    @Id
    private String routeId;

    private String sourceStation;
    private String destinationStation;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }
}
