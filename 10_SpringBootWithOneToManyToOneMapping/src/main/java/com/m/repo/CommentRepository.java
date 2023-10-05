package com.m.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m.model.Comment;

import jakarta.transaction.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	  List<Comment> findByTutorialId(Long postId);
	  
	  @Transactional
	  void deleteByTutorialId(long tutorialId);
}
