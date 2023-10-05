package com.oto.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oto.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{
	
	

}
