package com.finovate.address.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finovate.address.dto.AddressDTO;
import com.finovate.address.dto.ContactDTO;
import com.finovate.address.dto.ResponseTemplateDTO;
import com.finovate.address.exception.AddressException;
import com.finovate.address.model.Address;

import com.finovate.address.repository.AddressRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressService implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Address saveAddress(AddressDTO addressDTO) {
		Address addressData = new Address(addressDTO);
		return addressRepository.save(addressData);
	}

	public ResponseTemplateDTO getAddressWithPersonDetails(UUID aid) {
		ResponseTemplateDTO vo = new ResponseTemplateDTO();

		Address address = addressRepository.findByAid(aid);

		ContactDTO contactDTO = restTemplate.getForObject("http://localhost:9001/person/contact/" + address.getCid(),
				ContactDTO.class);
		log.info("bhushan" + contactDTO);
		System.out.println(contactDTO.toString());

		vo.setAddress(address);
		vo.setContactDTO(contactDTO);
		return vo;

	}

	@Override
	public List<Address> getAllPersonAddressData() {
		return addressRepository.findAll();
	}

	@Override
	public Address getAddresById(UUID Id) {
		Address res = addressRepository.findById(Id).orElseThrow(() -> new AddressException("details not found!"));
		return res;
	}

	@Override
	public void deletPersonAddresssByid(UUID contId) {
		addressRepository.deleteById(contId);
	}

}