package com.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.dto.RegisterRequest;
import com.dto.RegisterResponse;

public interface AuthenticationService {

	RegisterResponse RegisterUser(@RequestBody RegisterRequest register);

}
