package com.example.demo.repository;


import com.example.demo.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AirportRepository extends JpaRepository<Airport, Long> {
//    List<Airport> findByCity(String city);

}
