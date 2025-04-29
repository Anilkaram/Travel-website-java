package com.example.travel.model;

public class Hotel {
    private String id;
    private String name;
    private String location;
    private double pricePerNight;
    private int rating;
    private boolean available;

    // Constructors, getters, and setters
    public Hotel() {}

    public Hotel(String id, String name, String location, 
                 double pricePerNight, int rating, boolean available) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.rating = rating;
        this.available = available;
    }

    // Getters and setters for all fields
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}