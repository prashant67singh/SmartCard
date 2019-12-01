package com.noobcoders.smartcart.model.input;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
public class UserLogin {
    @NotNull
    @NotEmpty
    private String rfid;
    @NotNull
    @NotEmpty
    private String password;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "rfid='" + rfid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
