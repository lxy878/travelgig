package com.TravelGig.GateServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.GateServer.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    public Role findByName(String name);
}
