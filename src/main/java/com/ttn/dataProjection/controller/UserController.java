package com.ttn.dataProjection.controller;

import com.ttn.dataProjection.dto.UserDetailsDto;
import com.ttn.dataProjection.dto.UserDetailsProjectionDTO;
import com.ttn.dataProjection.entity.UserDetails;
import com.ttn.dataProjection.projection.UserDetailsProjection;
import com.ttn.dataProjection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public UserDetails createUser(@RequestBody UserDetails userDetails) {
       return userService.createUser(userDetails);
    }

    @GetMapping(value = "/getAll")
    public List<UserDetails> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/getAllByProjection")
    public List<UserDetailsProjection> getAllByProjection(){
        return userService.getAllUsersByProjection();
    }
    @GetMapping(value = "/getAllByDto")
    public List<UserDetailsDto> getAllByDto(){
        return userService.getAllByDto();
    }

    @GetMapping(value = "/getAllByJPQL")
    public List<UserDetailsProjectionDTO> getAllByJPQL(){
        return userService.getAllByJPQL();
    }
}
