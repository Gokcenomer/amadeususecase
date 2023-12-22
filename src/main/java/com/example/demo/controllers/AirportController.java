package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Airport;
import com.example.demo.service.AirportService;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/airports")

public class AirportController {

    @Autowired
    private AirportService airportService;


    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Optional<Airport> getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}
