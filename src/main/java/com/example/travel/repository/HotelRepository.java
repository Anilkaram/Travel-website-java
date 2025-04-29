package com.example.travel.repository;

import com.example.travel.model.Hotel;
import java.util.List;

public interface HotelRepository {
    List<Hotel> findAll();
    List<Hotel> findByLocation(String location);
    Hotel findById(String id);
    void save(Hotel hotel);
}