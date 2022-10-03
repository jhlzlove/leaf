package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService, UserDetailsPasswordService {

}
