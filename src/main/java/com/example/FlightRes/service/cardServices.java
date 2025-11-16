package com.example.FlightRes.service;

import com.example.FlightRes.entity.cardDetails;
import com.example.FlightRes.repositroy.cardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cardServices {

    @Autowired
    cardRepository cardRepository;

    public void saveCardDetails(cardDetails card) {
        cardRepository.save(card);
    }
}
