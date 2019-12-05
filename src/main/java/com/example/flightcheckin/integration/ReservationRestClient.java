package com.example.flightcheckin.integration;

import com.example.flightcheckin.dto.Reservation;
import com.example.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

     Reservation findReservation(Long id);

     Reservation updateReservation(ReservationUpdateRequest request);
}
