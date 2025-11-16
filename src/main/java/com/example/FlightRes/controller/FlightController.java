package com.example.FlightRes.controller;

import com.example.FlightRes.entity.FlightDetails;
import com.example.FlightRes.entity.Passenger;
import com.example.FlightRes.entity.cardDetails;
import com.example.FlightRes.service.FlightServices;
import com.example.FlightRes.service.PassengerServices;
import com.example.FlightRes.service.cardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class FlightController {

    @Autowired
    FlightServices flightServices;

    @Autowired
    PassengerServices passengerServices;

    @Autowired
    cardServices cardServices;


    @GetMapping("/")
    public String home() {
        return "search";   // redirect to your search page
    }

    @GetMapping("/flightSearch")
    private String SearchFlight(){
        return "search";
    }

    @PostMapping("/flightDetails")
    public String flightDetails(@RequestParam String source,@RequestParam String destination, @RequestParam LocalDate departureDate,Model model){
        List<FlightDetails> flight = flightServices.getFlightDetails(source,destination,departureDate);
        model.addAttribute("flights",flight);
        return "allFlights";
    }

    @PostMapping("/selectFlight")
    public String confirmFlight(@RequestParam Integer id,Model model){
        Optional<FlightDetails> confirmedFlight = flightServices.confirmFlight(id);
        if(confirmedFlight.isPresent()){
            FlightDetails presentFlight=confirmedFlight.get();
            model.addAttribute("confirmedFlight",presentFlight);
        }else{
            return "error";
        }

        return "reservation";

    }

    @PostMapping("/flightbooked")
    public String bookedFlight(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String phone,@RequestParam String email, @RequestParam String cardname,@RequestParam String cardnumber,@RequestParam LocalDate expiry,@RequestParam Integer cvv,@RequestParam Integer flightId
    ,Model model){
        Passenger passenger = new Passenger();
        passenger.setFirstName(firstname);
        passenger.setLastName(lastname);
        passenger.setEmail(email);
        passenger.setNumber(phone);

        cardDetails card = new cardDetails();
        card.setCardNumber(cardnumber);
        card.setName(cardname);
        card.setExpiryDate(expiry);
        card.setCvv(cvv);

        FlightDetails flight = flightServices.confirmFlight(flightId).get();
        passenger.setFlight(flight);
        card.setFlight(flight);

        passengerServices.savePassengerDetails(passenger);
        cardServices.saveCardDetails(card);

        model.addAttribute("passenger", passenger);
        model.addAttribute("confirmedFlight", flight);

        return "bookingSuccess";
    }
}
