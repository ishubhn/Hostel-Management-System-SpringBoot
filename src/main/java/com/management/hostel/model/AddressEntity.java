package com.management.hostel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String blockNo;
	private String address;
	private String landmark;
	private String cityName;
	private String state;
	private String country;

	@Pattern(regexp = "[0-9]{6}")
	private String pincode;
}
