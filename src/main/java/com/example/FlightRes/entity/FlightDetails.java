package com.example.FlightRes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="flights")
public class FlightDetails {

    @Id
    private int id;

    private String source;
    private String destination;
    private String airline;
    private String flightcode;
    private LocalDate departureDate;
}
