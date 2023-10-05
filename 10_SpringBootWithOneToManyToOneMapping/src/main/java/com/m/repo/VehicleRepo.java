package com.m.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.m.model.Vehicle;


@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
	

    List<Vehicle> findByOwner_Id(int ownerId);
}
