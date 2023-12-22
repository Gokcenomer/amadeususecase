package com.example.demo.scheduler;

import com.example.demo.models.Flight;
import com.example.demo.service.FlightService;
import com.example.demo.service.MockApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FlightDataScheduler {

    private final MockApiService mockApiService;
    private final FlightService flightService;

    @Autowired
    public FlightDataScheduler(MockApiService mockApiService, FlightService flightService) {
        this.mockApiService = mockApiService;
        this.flightService = flightService;
    }

    // Her gün saat 01:00'de çalışacak şekilde ayarlanmıştır.
    @Scheduled(cron = "0 0 1 * * ?")
    public void fetchAndSaveFlightData() {

        Flight mockFlightData = mockApiService.fetchFlightDataFromMockApi();


        flightService.createFlight(mockFlightData);

        System.out.println("Scheduled job is running. Mock data fetched and saved to the database.");
    }
}
