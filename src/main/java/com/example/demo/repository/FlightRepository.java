package com.example.demo.repository;

import com.example.demo.models.Airport;
import com.example.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {


    List<Flight> findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTime(
            String departureCity, String arrivalCity, LocalDateTime departureDateTime);

    List<Flight> findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTimeAndReturnDateTime(
            String departureCity, String arrivalCity, LocalDateTime departureDateTime, LocalDateTime returnDateTime);
}
