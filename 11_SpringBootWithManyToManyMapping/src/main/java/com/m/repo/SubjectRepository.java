package com.m.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.m.model.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findAllById(int subjectId);
    List<Subject> findByStudentsId(int id);
}
