package com.example.FlightRes.repositroy;

import com.example.FlightRes.entity.cardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cardRepository extends JpaRepository<cardDetails,Integer> {
}
