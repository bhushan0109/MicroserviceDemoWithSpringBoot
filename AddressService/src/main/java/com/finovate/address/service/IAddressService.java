package com.finovate.address.service;

import java.util.List;
import java.util.UUID;

import com.finovate.address.dto.AddressDTO;
import com.finovate.address.dto.ResponseTemplateDTO;
import com.finovate.address.model.Address;

public interface IAddressService {

	Address getAddresById(UUID Id);

	void deletPersonAddresssByid(UUID contId);

	Address saveAddress(AddressDTO addressDTO);

	List<Address> getAllPersonAddressData();

	public ResponseTemplateDTO getAddressWithPersonDetails(UUID id);
	

}