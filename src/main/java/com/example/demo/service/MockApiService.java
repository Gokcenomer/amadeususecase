package com.example.demo.service;
import com.example.demo.models.Airport;
import com.example.demo.models.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MockApiService {

    public Flight fetchFlightDataFromMockApi() {
        // Bu örnekte basit bir mock uçuş verisi üretiyoruz.
        Flight flightData = new Flight();
        flightData.setId(1L);
        flightData.setDepartureAirport(new Airport(1L, "Ankara"));
        flightData.setArrivalAirport(new Airport(2L, "Istanbul"));
        flightData.setDepartureDateTime(LocalDateTime.parse("2023-12-31T12:00:00"));
        flightData.setReturnDateTime(LocalDateTime.parse("2023-12-31T18:00:00"));
        flightData.setPrice(250.0);

        return flightData;
    }
}

