package com.finovate.contact.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.finovate.contact.dto.ContactDTO;
import com.finovate.contact.dto.ResponseDTO;
import com.finovate.contact.model.Contact;
import com.finovate.contact.service.IContactService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/person/contact")
public class ContactController {
	@Autowired
	private IContactService contactService;
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> saveContact(@Valid @RequestBody ContactDTO contact) {
		Contact personData = contactService.saveContact(contact);
		ResponseDTO responseDTO = new ResponseDTO("Successfully created the data ", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getAll" )
	public ResponseEntity<ResponseDTO> getPersonData() {
		List<Contact> personData = contactService.getPersonData();
		ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/{contId}")
	public ResponseEntity<Contact> findById(@PathVariable(value = "contId") UUID contId) {
		Contact personData = contactService.getContactById(contId);
		ResponseDTO responseDTO = new ResponseDTO("Successfully got the data ", personData);
		log.info(" "+responseDTO);
		return new ResponseEntity<>(personData, HttpStatus.OK);
	}

	@DeleteMapping("/{contId}")
	public ResponseEntity<ResponseDTO> deletPersonDataByid(@PathVariable("contId") UUID contId) {
		contactService.deletPersonDataByid(contId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted successfully the contact ", contId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
}
