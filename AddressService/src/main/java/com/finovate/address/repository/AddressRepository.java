package com.finovate.address.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finovate.address.dto.AddressDTO;
import com.finovate.address.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

	//Address findByaid(UUID aid);
	Address findByAid(UUID aid);

}