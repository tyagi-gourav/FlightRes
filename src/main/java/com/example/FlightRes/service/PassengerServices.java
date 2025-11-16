package com.example.FlightRes.service;

import com.example.FlightRes.entity.Passenger;
import com.example.FlightRes.repositroy.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerServices {
    @Autowired
    PassengerRepository passengerRepository;
    public void savePassengerDetails(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public Optional<Passenger> getPassengerById(Integer pid) {
        return passengerRepository.findById(pid);
    }

    public void savePassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }
}
