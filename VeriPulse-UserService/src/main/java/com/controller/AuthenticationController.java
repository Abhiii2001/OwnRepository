package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RegisterRequest;
import com.service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/v1/auth/")
@Tag(name = "Authentication APIs", description = "All APIs Are related to Authentication")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authService;

	@Operation(summary = "Register a new user", description = "Api used to add a user")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "User Saved Succefully"),
			@ApiResponse(responseCode = "400", description = "Bad Request User not saved") })
	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@Valid @RequestBody RegisterRequest register) {

		return new ResponseEntity(authService.RegisterUser(register), HttpStatus.OK);
	}

}
