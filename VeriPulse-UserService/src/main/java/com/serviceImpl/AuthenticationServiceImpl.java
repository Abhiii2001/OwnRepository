package com.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Role;
import com.Entity.User;
import com.dto.RegisterRequest;
import com.dto.RegisterResponse;
import com.enums.KycStatus;
import com.enums.RoleEnum;
import com.enums.UserStatus;
import com.exceptions.ResourceFoundException;
import com.repository.RoleRepo;
import com.repository.UserRepo;
import com.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public RegisterResponse RegisterUser(RegisterRequest register) {

		Optional<?> u1 = repo.findByEmail(register.getEmail());

		if (u1.isPresent()) {
			throw new ResourceFoundException("User Already Present Try with different credential");
		}
		ModelMapper model = new ModelMapper();
		User u = model.map(register, User.class);

		u.setCreatedAt(LocalDateTime.now());
		u.setKycStatus(KycStatus.PENDING);
		u.setUserStatus(UserStatus.ACTIVE);

		log.debug("ROle Assign");
		Role r = roleRepo.getById(1);
		u.setURole(r);

		repo.save(u);
		return new RegisterResponse("User Added Suceess!!");
	}

}
