package com.simplon.BriefSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplon.BriefSpring.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
