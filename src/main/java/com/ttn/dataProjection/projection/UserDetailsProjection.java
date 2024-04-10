package com.ttn.dataProjection.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"name","email","mobile","address","roles"})
public interface UserDetailsProjection {
     String getName();
     String getEmail();
     String getMobile();
     List<AddressProjection> getAddress();

     List<RolesProjection> getRoles();
}
