package com.example.FlightRes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class cardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private String name;
    private String cardNumber;
    private LocalDate expiryDate;
    private Integer cvv;
    @ManyToOne
    @JoinColumn(name = "flight_id")   // FK column in card_details table
    private FlightDetails flight;
}
