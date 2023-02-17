package com.simplon.BriefSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.BriefSpring.model.User;

public interface UserRoleRepository extends JpaRepository<User, Long> {

}
