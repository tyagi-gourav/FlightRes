package com.example.FlightRes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String firstName;
    private String lastName;
    private String number;
    private String email;
    @ManyToOne
    @JoinColumn(name = "flight_id")    // FK column in passenger table
    private FlightDetails flight;
    @Column(nullable = false)
    private boolean checkedIn = false;
    @Column(nullable = false)
    private Integer bags = 0;
}