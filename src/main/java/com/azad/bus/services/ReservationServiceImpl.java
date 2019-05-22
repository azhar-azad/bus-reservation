package com.azad.bus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azad.bus.entities.Bus;
import com.azad.bus.entities.Passenger;
import com.azad.bus.entities.Reservation;
import com.azad.bus.repos.BusRepository;
import com.azad.bus.repos.PassengerRepository;
import com.azad.bus.repos.ReservationRepository;
import com.azad.bus.util.EmailUtil;
import com.azad.bus.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	BusRepository busRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PdfGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	public Reservation bookTrip(Bus bus, Passenger passenger) {
		
		Reservation reservation = new Reservation();
		reservation.setBus(bus);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "D:/Azad/Documents/reservations/reservation"+savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
