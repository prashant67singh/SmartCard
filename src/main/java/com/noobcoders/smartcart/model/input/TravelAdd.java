package com.noobcoders.smartcart.model.input;

import javax.validation.constraints.NotNull;

public class TravelAdd {

    @NotNull
    private String stationName;
    @NotNull
    private Integer transportId;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }
}
