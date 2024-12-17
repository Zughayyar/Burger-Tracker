package com.axsosacademy.burgertracker.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "burgers")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 50, message = "Name must be between 2 - 50")
    private String name;

    @NotNull
    @Size(min = 2, max = 50, message = "Restaurant must be between 2 - 50")
    private String restaurant;

    @NotNull
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must not exceed 5")
    private Integer rating;

    @NotBlank(message = "Notes must not be blank")
    @Size(min = 5, max = 200, message = "Notes must be between 5 and 200 characters")
    private String notes;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Burger() {
    }

    public Burger(String name, String restaurant, int rating, String notes) {
        this.name = name;
        this.restaurant = restaurant;
        this.rating = rating;
        this.notes = notes;
    }

    // Getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public Integer getRating() {
        return rating;
    }

    public String getNotes() {
        return notes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
