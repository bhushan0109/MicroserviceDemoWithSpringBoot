package com.finovate.contact.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	public String firstName;

	/* @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Invalid phone number") */
	public String mobileNumber;
	
	
	
}