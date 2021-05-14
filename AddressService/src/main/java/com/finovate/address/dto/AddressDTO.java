package com.finovate.address.dto;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AddressDTO {

	private UUID cid;
//	@NotEmpty(message = "Address cannot be null")
	private String street;

	//@NotEmpty(message = "city cannot be null")
	private String city;

	//@NotEmpty(message = "state cannot be null")
	private String state;

//	@Pattern(regexp = "^[1-9]{1}[0-9]{5}$", message = "Invalid zip code")
	private String zipCode;

}