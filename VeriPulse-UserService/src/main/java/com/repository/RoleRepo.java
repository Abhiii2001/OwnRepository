package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Role;
import com.enums.RoleEnum;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	//Object findByRolename(RoleEnum roleEnum);

	Optional<Role> findByRolename(RoleEnum role);

}
