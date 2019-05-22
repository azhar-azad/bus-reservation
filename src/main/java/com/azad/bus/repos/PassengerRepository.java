package com.azad.bus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azad.bus.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
