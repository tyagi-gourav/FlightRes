package com.example.FlightRes.service;

import com.example.FlightRes.entity.Passenger;
import com.example.FlightRes.repositroy.FlightRepository;
import com.example.FlightRes.repositroy.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class reservationService {
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightRepository flightRepository;

    public Optional<Passenger> getReservationDetail(int id){
        return passengerRepository.findById(id);
    }
}
