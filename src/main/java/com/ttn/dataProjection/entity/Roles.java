package com.ttn.dataProjection.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;

}
