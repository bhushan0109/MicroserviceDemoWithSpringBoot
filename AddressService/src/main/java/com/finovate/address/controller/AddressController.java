package com.finovate.address.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finovate.address.dto.AddressDTO;
import com.finovate.address.dto.ResponseDTO;
import com.finovate.address.dto.ResponseTemplateDTO;
import com.finovate.address.model.Address;
import com.finovate.address.service.IAddressService;

@RestController
@RequestMapping("/person/address")
public class AddressController {
	@Autowired
	private IAddressService addressService;

	@PostMapping("/")
	public ResponseEntity<ResponseDTO>saveAddress(@Valid @RequestBody AddressDTO addressDTO) {
		Address addressData = addressService.saveAddress(addressDTO);
		ResponseDTO responseDTO = new ResponseDTO("Successfully created the data ", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping( "/getAll" )
	public ResponseEntity<ResponseDTO> getAllPersonAddressData() {
		List<Address> addressData = addressService.getAllPersonAddressData();
		ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/get/{contId}") public ResponseEntity<ResponseDTO>
	 * getAddresById(@PathVariable(value = "contId") UUID contId) { Address
	 * addressData = addressService.getAddresById(contId); ResponseDTO responseDTO =
	 * new ResponseDTO("Successfully got the data ", addressData); return new
	 * ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK); }
	 */

	@DeleteMapping("/delete/{contId}")
	public ResponseEntity<ResponseDTO> deletPersonAddresssByid(@PathVariable UUID contId) {
		addressService.deletPersonAddresssByid(contId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted successfully the address ", contId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	@GetMapping("/{contId}")
	public ResponseEntity<ResponseDTO> getAddressWithPersonDetails(@PathVariable(value = "contId") UUID contId) {
		ResponseTemplateDTO addressData = addressService.getAddressWithPersonDetails(contId);
		ResponseDTO responseDTO = new ResponseDTO("Successfully got the data ", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}