package com.student.reg.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.student.reg.dto.UserDTO;
import com.student.reg.Repository.UserServiceRepository;
import com.student.reg.entity.UserEntity;
import com.student.reg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserServiceRepository userServiceRepository;

	/*
	 * To Add user
	 *
	 * @param userid
	 * @param name 
	 * return successfully inserted
	 */
	@Override
	public String addUser(UserDTO userDTO) {
		UserEntity user = new UserEntity();
		user.setId(userDTO.getUserId());
		user.setName(userDTO.getName());
		userServiceRepository.save(user);
		return "Inserted";
	}

	@Override
	public List<UserDTO> getUserById(Integer userId) {
		UserEntity user = userServiceRepository.findById(userId).get();
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId(user.getId());
		userDTO.setName(user.getName());
		List<UserDTO> list=new ArrayList<UserDTO>();
		list.add(userDTO);
		return list;
	}

	/*
	 * To get all users
	 * return all users
	 */
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserEntity> users = userServiceRepository.findAll();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (UserEntity user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(user.getId());
			userDTO.setName(user.getName());
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	/*
	 * To update user
	 *
	 * @param userid
	 * @param name 
	 * return successfully updated
	 */
	@Override
	public String updateUser(UserDTO userDTO) {
		UserEntity user = new UserEntity();
		user.setId(userDTO.getUserId());
		user.setName(userDTO.getName());
		userServiceRepository.save(user);
		return "Updated";
	}

	
	/*
	 * To delete user
	 *
	 * @param userid
	 * @param name 
	 * return successfully deleted
	 */
	@Override
	public String deleteUser(UserDTO userDTO) {
		UserEntity user = new UserEntity();
		user.setId(userDTO.getUserId());
		user.setName(userDTO.getName());
		userServiceRepository.delete(user);
		return "Deleted";
	}

}
