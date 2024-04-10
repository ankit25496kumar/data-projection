package com.ttn.dataProjection.service;

import com.ttn.dataProjection.dto.UserDetailsDto;
import com.ttn.dataProjection.dto.UserDetailsProjectionDTO;
import com.ttn.dataProjection.entity.UserDetails;
import com.ttn.dataProjection.projection.UserDetailsProjection;

import java.util.List;

public interface UserService {
    UserDetails createUser(UserDetails userDetails);

    List<UserDetails> getAllUsers();

    UserDetails getUserById(Long id);

    List<UserDetailsProjection> getAllUsersByProjection();

    List<UserDetailsDto> getAllByDto();

    List<UserDetailsProjectionDTO> getAllByJPQL();
}
