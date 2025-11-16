package com.example.FlightRes.repositroy;

import com.example.FlightRes.entity.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<FlightDetails,Integer> {

    List<FlightDetails> findBySourceAndDestinationAndDepartureDate(String source, String destination, LocalDate departureDate);

}
