package com.management.hostel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hostel")
public class HostelEntity {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String hostelId;

	private String name;
	@Column(nullable = false)
	@NotBlank(message = "Contact number is mandatory")
	private String contactNumber;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	@Column(nullable = false)
	private String emailId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private AddressEntity address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_phone_number")
	private OwnerEntity owner;
}

