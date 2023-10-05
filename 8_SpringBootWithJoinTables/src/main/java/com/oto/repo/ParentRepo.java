package com.oto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oto.model.Parent;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Integer> {

}
