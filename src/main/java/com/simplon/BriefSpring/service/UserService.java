package com.simplon.BriefSpring.service;

import java.util.List;

import com.simplon.BriefSpring.model.User;
import com.simplon.BriefSpring.model.UserDto;

public interface UserService {
	 void saveUser(UserDto userDto);

	    User findUserByEmail(String email);

	    List<UserDto> findAllUsers();
}
