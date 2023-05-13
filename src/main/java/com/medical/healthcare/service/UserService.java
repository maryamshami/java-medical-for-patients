package com.medical.healthcare.service;

import com.medical.healthcare.controller.dto.UserRegistrationDto;
import com.medical.healthcare.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    
    User findByEmail(String email);
    User findByIdentificationNumber(String identificationNumber);
    User save(UserRegistrationDto registration);
}