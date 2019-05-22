package com.azad.bus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azad.bus.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	
}
