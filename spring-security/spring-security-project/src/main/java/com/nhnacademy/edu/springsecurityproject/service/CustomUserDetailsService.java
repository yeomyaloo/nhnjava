package com.nhnacademy.edu.springsecurityproject.service;

import com.nhnacademy.edu.springsecurityproject.entity.Resident;
import com.nhnacademy.edu.springsecurityproject.repositoty.ResidentRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ResidentRepository residentRepository;

    public CustomUserDetailsService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Integer id = residentRepository.findByUserId(username).getResidentSerialNumber();

        Resident resident = residentRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException(username + "not found"));

        return new User(resident.getUserId(), resident.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(resident.getResidentSerialNumber().toString())));
    }


}
