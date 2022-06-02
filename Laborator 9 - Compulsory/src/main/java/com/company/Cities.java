package com.company;


import org.junit.Test;


public class Cities {
    public Integer id;
    public String country;
    public String name;
    public Integer capital;
    public Double latitude;
    public Double longitude;

    public Cities(Integer id, String country, String name, Integer capital, Double latitude, Double longitude) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static String Print(){
        return "Class from Lab 9 - Compulsory";
    }

    @Test
    public void Verify(){
       this.setLatitude(this.getLatitude()+10);
    }


}
