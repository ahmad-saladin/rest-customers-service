package com.jumia.service.dto;

import java.io.Serializable;

public class CustomerFilterDTO implements Serializable {

    private static final long serialVersionUID = 5261970256897778888L;
    private String country;
    private String state;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
