package com.finovate.address.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.finovate.address.dto.AddressDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "uuid-char") // pk
	@Column(name = "aid")
	private UUID aid;
	private String street;
	private String city; // variable and fields of person address
	private String state;
	private String zipCode;
	private UUID cid; // p/k of contact

	public Address(AddressDTO addressDTO) {

		this.street = addressDTO.getStreet();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.zipCode = addressDTO.getZipCode();
		this.cid = addressDTO.getCid();
		
	}


}