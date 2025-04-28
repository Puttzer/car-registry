package com.example.registry.model;

public class Car {
    private String registration;
    private String brand_id;

    public Car() {
    }

    public Car(String registration, String brand_id) {
        this.registration = registration;
        this.brand_id = brand_id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }
}
