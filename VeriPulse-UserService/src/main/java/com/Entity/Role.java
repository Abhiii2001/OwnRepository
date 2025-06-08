package com.Entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.enums.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "rolename", nullable = false, unique = true)
	private RoleEnum rolename;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "uRole")
	List<User> users;

	@CreationTimestamp
	private Instant createdAt;

	@CreationTimestamp
	private Instant updatedAt;

}
