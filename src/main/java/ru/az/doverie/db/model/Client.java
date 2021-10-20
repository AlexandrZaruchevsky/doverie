package ru.az.doverie.db.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Client {

    private Long id;
    private String fullName;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthday;
    private String birthPlace;
    private String serialNumberPasport;
    private String issuedBy;
    private String postCode;
    private String regionCode;
    private String region;
    private String district;
    private String location;
    private String street;
    private String house;
    private String block;
    private String build;
    private String apart;

}
