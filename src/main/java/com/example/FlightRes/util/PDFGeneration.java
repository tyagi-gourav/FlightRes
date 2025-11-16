package com.example.FlightRes.util;

import com.example.FlightRes.entity.FlightDetails;
import com.example.FlightRes.entity.Passenger;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGeneration {

    public void generateInternary(FlightDetails flightDetails, Passenger passenger,String filepath){
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,new FileOutputStream(filepath));
            document.open();
            document.add(generateTale(flightDetails,passenger));
            document.close();
        }catch (FileNotFoundException | DocumentException e){
            e.printStackTrace();
        }


    }

    private PdfPTable generateTale(FlightDetails flightDetails, Passenger passenger) {
        PdfPTable pdfPTable=new PdfPTable(2);
        PdfPCell pdfPCell;
        pdfPCell = new PdfPCell(new Phrase("Flight Itinerary"));
        pdfPCell.setColspan(2);
        pdfPTable.addCell(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase("Flight Details"));
        pdfPCell.setColspan(2);
        pdfPTable.addCell(pdfPCell);


        pdfPTable.addCell("Airline");
        pdfPTable.addCell(flightDetails.getAirline());
        pdfPTable.addCell("Departure city");
        pdfPTable.addCell(flightDetails.getSource());
        pdfPTable.addCell("Arrival City");
        pdfPTable.addCell(flightDetails.getDestination());
        pdfPTable.addCell("Flight Number");
        pdfPTable.addCell(flightDetails.getFlightcode());
        pdfPTable.addCell("Departure Date");
        pdfPTable.addCell(flightDetails.getDepartureDate().toString());

        pdfPCell = new PdfPCell(new Phrase("Passenger Details"));
        pdfPCell.setColspan(2);
        pdfPTable.addCell(pdfPCell);

        pdfPTable.addCell("First Name");
        pdfPTable.addCell(passenger.getFirstName());
        pdfPTable.addCell("Last Name");
        pdfPTable.addCell(passenger.getLastName());
        pdfPTable.addCell("Email");
        pdfPTable.addCell(passenger.getEmail());
        pdfPTable.addCell("Phone");
        pdfPTable.addCell(passenger.getNumber());


        return pdfPTable;
    }


}
