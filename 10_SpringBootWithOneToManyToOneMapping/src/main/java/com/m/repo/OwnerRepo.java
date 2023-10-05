package com.m.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.m.dto.OwnerDto;
import com.m.model.Owner;



@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {
	
	   @Query("SELECT new com.m.dto.OwnerDto(o.id, o.name, v) FROM Owner AS o INNER JOIN Vehicle AS v ON v.owner.id=o.id  WHERE o.id = ?1")
	    public List<OwnerDto> listAllNamesAndParentNames(Long ownerId);
	   
	   @Query("FROM Owner o INNER JOIN Vehicle v ON v.owner.id=o.id WHERE o.id = :id")
		List<Owner> listAll(Long id);
}