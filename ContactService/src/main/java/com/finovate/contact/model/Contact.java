package com.finovate.contact.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.finovate.contact.dto.ContactDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "uuid-char") // pk
	@Column(name = "cid")
	private UUID cid;
	private String firstName;
	private String mobileNumber;

	public Contact(ContactDTO contactDTO) { // argument constructor

		this.firstName = contactDTO.firstName;

		this.mobileNumber = contactDTO.mobileNumber;

	}

}