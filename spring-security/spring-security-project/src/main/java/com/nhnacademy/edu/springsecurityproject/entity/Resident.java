package com.nhnacademy.edu.springsecurityproject.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name ="resident")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Resident implements UserDetails {

    @Id
    @Column(name = "resident_serial_number")
    private Integer residentSerialNumber;

    private String name;

    @Column(name = "resident_registration_number")
    private String residentRegistrationNumber;

    @Column(name = "gender_code")
    private String genderCode;


    @Column(name = "birth_date")
    private Timestamp birthDate;

    @Column(name = "birth_place_code")
    private String birthPlaceCode;

    @Column(name = "registration_base_address")
    private String registrationBaseAddress;

    @Column(name = "death_date")
    private Timestamp deathDate;

    @Column(name = "death_place_code")
    private String deathPlaceCode;

    @Column(name = "death_place_address")
    private String deathPlaceAddress;


    @Column(name = "id")
    private String userId;

    @Column(name = "password")
    private String pwd;
    private String email;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return userId;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
