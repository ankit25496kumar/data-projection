package com.ttn.dataProjection.dto;

import lombok.Data;

@Data
public class UserDetailsProjectionDTO {
    private String name;
    private String email;
    private String city;
    private String pincode;

    public UserDetailsProjectionDTO(String name, String email, String city, String pincode) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.pincode = pincode;
    }
}

