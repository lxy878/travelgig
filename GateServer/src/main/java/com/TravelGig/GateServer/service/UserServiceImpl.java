package com.TravelGig.GateServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TravelGig.GateServer.domain.Role;
import com.TravelGig.GateServer.domain.User;
import com.TravelGig.GateServer.repository.RoleRepository;
import com.TravelGig.GateServer.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User createUser(User user) {
        for(String rn : user.getRoleNames()){
            Role r = roleRepository.findByName(rn);
            if(r==null) r = new Role(rn);
            user.getRoles().add(r);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
