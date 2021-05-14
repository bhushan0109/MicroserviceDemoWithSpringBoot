package com.finovate.contact.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finovate.contact.dto.ContactDTO;
import com.finovate.contact.exception.ContactException;

import com.finovate.contact.model.Contact;
import com.finovate.contact.repository.ContactRepository;

@Service
public class ContactService implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	
	@Override
	public Contact saveContact(ContactDTO contactDTO) {
		Contact contact = new Contact(contactDTO);

		// List<Address> address = (List<Address>)
		// addressRepository.findById(UUID.fromString(contactDTO.addressID)).orElseThrow(()->
		// new AddressException("details not found!"));
		// contact.setAddress(address);
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getPersonData() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(UUID Id) {
		return contactRepository.findById(Id).orElseThrow(() -> new ContactException("details not found!"));
	}

	@Override
	public void deletPersonDataByid(UUID contId) {

		contactRepository.deleteById(contId);
	}




}