package com.management.hostel.model.dto.response;

import com.management.hostel.model.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	private String firstName;
	private String lastName;
	private String gender;
	private String phoneNumber;
	private String emailId;
	private LocalDate dateOfBirth;
	private AddressEntity permanentAddress;
}
