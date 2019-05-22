package com.azad.bus.services;

import com.azad.bus.entities.Bus;
import com.azad.bus.entities.Passenger;
import com.azad.bus.entities.Reservation;

public interface ReservationService {

	public Reservation bookTrip(Bus bus, Passenger passenger);
}
