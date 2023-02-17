package com.simplon.BriefSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.BriefSpring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
