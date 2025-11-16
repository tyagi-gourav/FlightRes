package com.example.FlightRes.service;

import com.example.FlightRes.entity.FlightDetails;
import com.example.FlightRes.repositroy.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightServices {

    @Autowired
    FlightRepository flightRepository;

    public List<FlightDetails> getFlightDetails(String source, String destination, LocalDate departureDate) {
        return flightRepository.findBySourceAndDestinationAndDepartureDate(source,destination,departureDate);

    }
    public Optional<FlightDetails> confirmFlight(Integer id){
        return flightRepository.findById(id);
    }
}
