package com.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.enums.KycStatus;
import com.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private int id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "uFirstName")
	private String uFirstName;

	@Column(name = "userMiddleName")
	private String userMiddleName;

	@Column(name = "userLastName")
	private String userLastName;

	@Column(name = "mobileNumber", length = 10)
	private long mobileNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "RoleId")
	private Role uRole;

	@CreationTimestamp
	@Column(name = "createdAt")
	private LocalDateTime createdAt;

	@CreationTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "userStatus")
	private UserStatus userStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = "kycStatus")
	private KycStatus kycStatus;

}
