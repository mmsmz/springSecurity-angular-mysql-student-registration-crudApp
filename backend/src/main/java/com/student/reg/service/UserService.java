package com.student.reg.service;

import java.util.List;

import com.student.reg.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	String addUser(UserDTO userDTO);

	List<UserDTO> getUserById(Integer userId);

	List<UserDTO> getAllUsers();

	String updateUser(UserDTO userDTO);

	String deleteUser(UserDTO userDTO);
}
