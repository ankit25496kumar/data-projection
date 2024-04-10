package com.ttn.dataProjection.repository;

import com.ttn.dataProjection.dto.UserDetailsProjectionDTO;
import com.ttn.dataProjection.entity.UserDetails;
import com.ttn.dataProjection.projection.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    List<UserDetailsProjection> findAllByActiveTrue();

    @Query("SELECT NEW com.ttn.dataProjection.dto.UserDetailsProjectionDTO(u.name, u.email, a.city, a.pincode) FROM UserDetails u JOIN u.address  a")
    List<UserDetailsProjectionDTO> findAllByActiveTrueOrderByNameDesc();

}
