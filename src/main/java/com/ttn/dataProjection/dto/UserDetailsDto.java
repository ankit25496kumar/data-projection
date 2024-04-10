package com.ttn.dataProjection.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder({"name","email","mobile","address","roles"})
public class UserDetailsDto {
    private String name;
    private String email;
    private String mobile;
    private List<AddressDto> address;
    private List<RolesDto> roles;
}
