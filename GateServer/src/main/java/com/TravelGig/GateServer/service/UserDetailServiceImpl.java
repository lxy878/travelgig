package com.TravelGig.GateServer.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TravelGig.GateServer.domain.Role;
import com.TravelGig.GateServer.domain.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // find user by name (require user and role tables, service ....)
        User user = userService.findByEmail(email);
        // add role name as SimpleGrantedAuthority to GrantedAuthority
        Set<GrantedAuthority> roles = new HashSet<>();
        for(Role r : user.getRoles()){
            // System.out.println(r.getName());
            roles.add(new SimpleGrantedAuthority(r.getName()));
        }
        // return userdetails.User with user name, password and roles
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),roles);
    }
    
}
