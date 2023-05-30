package com.fooddelivery.food_delivery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private float price;

    private String picture;

    public Food() {

    }

    public Food(Long id, String name, float price, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    // Getters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public String getPicture() {
        return this.picture;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
