package com.finovate.address.dto;



import com.finovate.address.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseTemplateDTO {
	private Address address ;
	private ContactDTO contactDTO;
	/*
	 * public Object setAddress; public Object setContact;
	 */

}
