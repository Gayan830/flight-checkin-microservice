package com.example.flightcheckin.controllers;

import com.example.flightcheckin.dto.Reservation;
import com.example.flightcheckin.dto.ReservationUpdateRequest;
import com.example.flightcheckin.integration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckinController {

    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin(){
        return "startCheckin";
    }

    @RequestMapping("/startCheckin")
    public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap){
        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);

        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    public String completeCheckin(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags){
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        System.out.println(reservationId);
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);
        reservationUpdateRequest.setCheckedIn(true);
        restClient.updateReservation(reservationUpdateRequest);
        return "checkinConfirmation";
    }

}
