package com.ttn.dataProjection.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String email;
    private String mobile;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    @ManyToMany
    private List<Roles> roles;

    private boolean active;

}
