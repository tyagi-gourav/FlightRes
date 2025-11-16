package com.example.FlightRes.controller;

import com.example.FlightRes.entity.FlightDetails;
import com.example.FlightRes.entity.Passenger;
import com.example.FlightRes.service.PassengerServices;
import com.example.FlightRes.service.reservationService;
import com.example.FlightRes.util.PDFGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/")
public class ReservationController {

    @Autowired
    reservationService reservationservice;
    @Autowired
    PassengerServices passengerServices;
    @Autowired
    PDFGeneration pdfGeneration;

    @GetMapping("/reservation")
    public String reservation(){
        return "reservationForm";
    }

    @GetMapping("/reservationDetails")
    public String reservationDetails(@RequestParam int reservationId, Model model){
        Optional<Passenger> pass = reservationservice.getReservationDetail(reservationId);
        if(pass.isPresent()){
            Passenger passenger1 =pass.get();
            FlightDetails flightDetails1=passenger1.getFlight();
            model.addAttribute("passenger1",passenger1);
            model.addAttribute("flightDetails1",flightDetails1);
            String filepath = "D:\\reservations\\reservation"+flightDetails1.getId()+".pdf";
            pdfGeneration.generateInternary(flightDetails1,passenger1,filepath);
        }
        return "checkin";
    }
    @PostMapping("/checkIn")
    public String checkIn(@RequestParam Integer pid,
                          @RequestParam Integer bags,Model model) {

        Optional<Passenger> passenger = passengerServices.getPassengerById(pid);
        if(passenger.isPresent()){
            Passenger passenger1=passenger.get();
            passenger1.setCheckedIn(true);
            passenger1.setBags(bags);  // ✅ store bags count

            passengerServices.savePassenger(passenger1);
            model.addAttribute("passenger1", passenger1);
            model.addAttribute("flightDetails1", passenger1.getFlight());

        }

        return "checkin-success";


    }


}
