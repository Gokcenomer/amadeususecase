package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Flight;
import com.example.demo.service.FlightService;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam LocalDateTime departureDateTime,
            @RequestParam(required = false) LocalDateTime returnDateTime) {

        List<Flight> foundFlights = flightService.searchFlights(departureCity, arrivalCity, departureDateTime, returnDateTime);

        if (foundFlights.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foundFlights, HttpStatus.OK);
        }
    }
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Optional<Flight> getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }
}
