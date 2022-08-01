package com.TravelGig.GateServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.GateServer.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    public User findByEmail(String email);
}
