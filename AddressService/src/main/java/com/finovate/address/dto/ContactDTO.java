package com.finovate.address.dto;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ContactDTO {

	/*
	 * @NotNull
	 * 
	 * @Size(max = 65)
	 * 
	 * @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Invalid firstName")
	 */
	private UUID cid;
	public String firstName;

	/* @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Invalid phone number") */
	public  String mobileNumber;

	// private AddressDTO addressDTO;
}