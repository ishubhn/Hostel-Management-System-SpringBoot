package com.management.hostel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity {

	@Id
	@Column(nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String emailId;

	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNumber;

	@NotBlank(message = "Password is mandatory")
	@Column(nullable = false)
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{4,}$",
//			message = "Password must contain at least 1 digit, 1 lowercase, 1 uppercase and" +
//					"1 symbol characters")
	private String password;

	private String firstName;
	private String lastName;
	private String gender;

	@Column(name = "date_of_birth", nullable = false)
	@Past(message = "Date should be in past")
	@NotBlank(message = "Date of birth is mandatory")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "permanent_address_id")
	private AddressEntity permanentAddress;
}
