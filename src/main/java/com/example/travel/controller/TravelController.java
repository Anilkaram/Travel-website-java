package com.example.travel.controller;

import com.example.travel.model.Flight;
import com.example.travel.model.Hotel;
import com.example.travel.repository.FlightRepository;
import com.example.travel.repository.HotelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TravelController {

    private final FlightRepository flightRepository;
    private final HotelRepository hotelRepository;

    public TravelController(FlightRepository flightRepository, HotelRepository hotelRepository) {
        this.flightRepository = flightRepository;
        this.hotelRepository = hotelRepository;
        
        // Initialize with sample data
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Sample flights
        flightRepository.save(new Flight("F100", "Air India", "Delhi", "Mumbai", 
                                       "10:00", "12:00", 5000));
        flightRepository.save(new Flight("F101", "IndiGo", "Mumbai", "Goa", 
                                       "14:00", "15:00", 3500));
        flightRepository.save(new Flight("F102", "SpiceJet", "Bangalore", "Delhi", 
                                       "08:00", "10:30", 6000));

        // Sample hotels
        hotelRepository.save(new Hotel("H100", "Taj Mahal Palace", "Mumbai", 
                                     12000, 5, true));
        hotelRepository.save(new Hotel("H101", "The Leela Palace", "Delhi", 
                                     15000, 5, true));
        hotelRepository.save(new Hotel("H102", "Grand Hyatt", "Goa", 
                                     8000, 4, true));
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/flights")
    public String showFlights(Model model) {
        model.addAttribute("flights", flightRepository.findAll());
        return "flights";
    }

    @GetMapping("/hotels")
    public String showHotels(Model model) {
        model.addAttribute("hotels", hotelRepository.findAll());
        return "hotels";
    }

    @GetMapping("/search")
    public String search(@RequestParam String type,
                         @RequestParam(required = false) String departure,
                         @RequestParam(required = false) String arrival,
                         @RequestParam(required = false) String location,
                         Model model) {
        
        if ("flight".equals(type)) {
            model.addAttribute("results", flightRepository.findByRoute(departure, arrival));
            model.addAttribute("searchType", "flights");
        } else if ("hotel".equals(type)) {
            model.addAttribute("results", hotelRepository.findByLocation(location));
            model.addAttribute("searchType", "hotels");
        }
        
        return "search";
    }
}