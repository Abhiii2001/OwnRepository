package com.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Validated
public class RegisterRequest {

	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Username is required")
	@Size(min = 4, max = 20, message = "Username must be 4 - 20 Charecter")
	private String userName;
	
	@NotNull(message = "uFirstName is required")
	@Size(min = 4, max = 20, message = "uFirstName must be 4 - 20 Charecter")
	private String uFirstName;

	@NotNull(message = "Middlename is required")
	@Size(min = 4, max = 20, message = "Middlename must be 4 - 20 Charecter")
	private String userMiddleName;

	@NotNull(message = "LastName is required")
	@Size(min = 4, max = 20, message = "LastName must be 4 - 20 Charecter")
	private String userLastName;

	@Min(value = 1000000000L, message = "Mobile Number Must Be 10 Digits")
	@Max(value = 9999999999L, message = "Mobile Number Must Be 10 Digits")
	@Digits(integer = 10, fraction = 0, message = "Mobile Number must be 10 digits")
	private long mobileNumber;

	@Email(message = "Invalid Email Format")
	private String email;

	@NotBlank(message = "Password is required")
	@Length(min = 8, max = 20, message = "Password must be 8 charecter")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Password must contain digit,lowercase,uppercase,and special charecter")
	private String password;

}
