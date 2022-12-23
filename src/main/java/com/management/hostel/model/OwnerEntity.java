package com.management.hostel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class OwnerEntity {

	@Id
	@Column(nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String emailId;

	private String firstName;
	private String lastName;

	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNumber;

	@Pattern(regexp = "^[0-9]{10}$")
	private String alternameContact;
}
