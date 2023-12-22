package com.example.demo.service;

import com.example.demo.models.Flight;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;


    public List<Flight> searchFlights(String departureCity, String arrivalCity,
                                      LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        if (returnDateTime == null) {
            // If returnDateTime is null, it's a one-way flight
            return flightRepository.findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTime(
                    departureCity, arrivalCity, departureDateTime);
        } else {
            // If returnDateTime is provided, it's a round-trip flight
            return flightRepository.findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTimeAndReturnDateTime(
                    departureCity, arrivalCity, departureDateTime, returnDateTime);
        }
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {

        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }


}
