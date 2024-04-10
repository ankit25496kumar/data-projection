package com.ttn.dataProjection.service.impl;

import com.ttn.dataProjection.dto.AddressDto;
import com.ttn.dataProjection.dto.RolesDto;
import com.ttn.dataProjection.dto.UserDetailsDto;
import com.ttn.dataProjection.dto.UserDetailsProjectionDTO;
import com.ttn.dataProjection.entity.UserDetails;
import com.ttn.dataProjection.projection.UserDetailsProjection;
import com.ttn.dataProjection.repository.UserDetailsRepository;
import com.ttn.dataProjection.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetails createUser(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return userDetailsRepository.findAll();
    }

    @Override
    public UserDetails getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDetailsProjection> getAllUsersByProjection() {
        return userDetailsRepository.findAllByActiveTrue();
    }

    @Override
    public List<UserDetailsDto> getAllByDto() {
      List<UserDetails> userDetailsList=  userDetailsRepository.findAll();
      List<UserDetailsDto> userDetailsDtoList=new ArrayList<>();
        userDetailsList.forEach(userDetails -> {
            UserDetailsDto userDetailsDto=new UserDetailsDto();
            BeanUtils.copyProperties(userDetails,userDetailsDto);
            List<AddressDto> addressDtoList=new ArrayList<>();
            userDetails.getAddress().forEach(address -> {
                AddressDto addressDto=new AddressDto();
                BeanUtils.copyProperties(address,addressDto);
                addressDtoList.add(addressDto);
            });
            userDetailsDto.setAddress(addressDtoList);
            List<RolesDto> rolesDtoList=new ArrayList<>();
            userDetails.getRoles().forEach(roles -> {
                RolesDto rolesDto=new RolesDto();
                BeanUtils.copyProperties(roles,rolesDto);
                rolesDtoList.add(rolesDto);
            });
            userDetailsDto.setRoles(rolesDtoList);
            userDetailsDtoList.add(userDetailsDto);
        });
        return userDetailsDtoList;
    }

    @Override
    public List<UserDetailsProjectionDTO> getAllByJPQL() {
        return userDetailsRepository.findAllByActiveTrueOrderByNameDesc();
    }
}
