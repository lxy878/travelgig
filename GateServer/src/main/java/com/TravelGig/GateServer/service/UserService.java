package com.TravelGig.GateServer.service;

import com.TravelGig.GateServer.domain.User;

public interface UserService {
    public User findByEmail(String email);
    public User createUser(User user);
}
