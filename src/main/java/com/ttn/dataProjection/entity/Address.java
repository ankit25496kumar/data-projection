package com.ttn.dataProjection.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String city;
    private String state;
    private String country;
    private String pincode;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}
