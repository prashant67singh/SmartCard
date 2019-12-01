package com.noobcoders.smartcart.model;

import javax.persistence.*;

@Entity
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    @ManyToOne
    @JoinColumn(name = "transport_mode_id", nullable = false)
    private TransportationMode transportationMode;

    @OneToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public TransportationMode getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
