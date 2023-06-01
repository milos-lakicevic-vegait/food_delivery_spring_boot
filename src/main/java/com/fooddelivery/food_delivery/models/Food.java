package com.fooddelivery.food_delivery.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // GenerationType.IDENTITY
    private Long id;

    @Column(nullable = false, length = 255, unique = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 255)
    private String picture;

    public Food() {

    }

    public Food(String name, Double price, String picture) {
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

    public Double getPrice() {
        return this.price;
    }

    public String getPicture() {
        return this.picture;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
