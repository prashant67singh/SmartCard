package com.noobcoders.smartcart.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(RoutePathId.class)
public class RoutePath implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route routeId;

    @Id
    private Integer stationNumber;

    private String stationName;

    private Integer accumulativeDistance;

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Integer getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(Integer stationNumber) {
        this.stationNumber = stationNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getAccumulativeDistance() {
        return accumulativeDistance;
    }

    public void setAccumulativeDistance(Integer accumulativeDistance) {
        this.accumulativeDistance = accumulativeDistance;
    }
}

class RoutePathId implements Serializable {
    private Route routeId;
    private Integer stationNumber;
}
