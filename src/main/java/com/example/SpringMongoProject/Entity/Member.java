package com.example.SpringMongoProject.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Member {
    @Id
    private String id;
    private String fullName;
    private String phoneNumber;
    private String password;
    private String provinceCity;
    private String districtWard;

    public Member() {}

    public Member(String fullName, String phoneNumber, String password, String provinceCity, String districtWard) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.provinceCity = provinceCity;
        this.districtWard = districtWard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvinceCity() {
        return provinceCity;
    }

    public void setProvinceCity(String provinceCity) {
        this.provinceCity = provinceCity;
    }

    public String getDistrictWard() {
        return districtWard;
    }

    public void setDistrictWard(String districtWard) {
        this.districtWard = districtWard;
    }
}