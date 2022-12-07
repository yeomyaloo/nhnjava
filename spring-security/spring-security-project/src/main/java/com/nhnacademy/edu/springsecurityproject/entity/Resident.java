package com.nhnacademy.edu.springsecurityproject.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
@Entity
@Table(name ="resident")
@Getter
@RequiredArgsConstructor
public class Resident implements Serializable {

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

    private String id;
    private String password;
    private String email;

    public Resident(Integer residentSerialNumber, String name, String residentRegistrationNumber, String genderCode, Timestamp birthDate, String birthPlaceCode, String registrationBaseAddress) {
        this.residentSerialNumber = residentSerialNumber;
        this.name = name;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.genderCode = genderCode;
        this.birthDate = birthDate;
        this.birthPlaceCode = birthPlaceCode;
        this.registrationBaseAddress = registrationBaseAddress;
    }

    public Resident(Integer residentSerialNumber, String name, String residentRegistrationNumber, String genderCode, Timestamp birthDate, String birthPlaceCode, String registrationBaseAddress, Timestamp deathDate, String deathPlaceCode, String deathPlaceAddress, String id, String password, String email) {
        this.residentSerialNumber = residentSerialNumber;
        this.name = name;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.genderCode = genderCode;
        this.birthDate = birthDate;
        this.birthPlaceCode = birthPlaceCode;
        this.registrationBaseAddress = registrationBaseAddress;
        this.deathDate = deathDate;
        this.deathPlaceCode = deathPlaceCode;
        this.deathPlaceAddress = deathPlaceAddress;
        this.id = id;
        this.password = password;
        this.email = email;
    }
}
