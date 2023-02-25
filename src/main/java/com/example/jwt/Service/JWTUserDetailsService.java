package com.example.jwt.Service;

import com.example.jwt.DTO.EmployeeDTO;
import com.example.jwt.Entity.Employee;
import com.example.jwt.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),true,true,true,true, Collections.singleton(getAuthority(user)));
    }
    private SimpleGrantedAuthority getAuthority(Employee user) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRoleName());


        return authority;
    }


    public Employee save(Employee user) {
        Employee newUser = new Employee();
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setEmail(user.getEmail());
        newUser.setRoleName(user.getRoleName());

        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }
}

