package com.student.reg.controller;

import com.student.reg.dto.ResponseDTO;
import com.student.reg.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.student.reg.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	/*
	 * To Add user
	 *
	 * @param userid
	 * 
	 * @param name return successfully inserted
	 */
	@PostMapping(value = "/addUser", produces = "application/json")
	public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Success");
		responseDTO.setData(userService.addUser(userDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/*
	 * To Add
	 *
	 * @param userid
	 * 
	 * @param name return successfully inserted
	 */
	@GetMapping(value = "/getUserById", produces = "application/json")
	public ResponseEntity<ResponseDTO> getUserById(@RequestParam Integer userId) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Success");
		responseDTO.setData(userService.getUserById(userId));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/*
	 * To get all users return all users
	 */
	@GetMapping(value = "/getAllUsers", produces = "application/json")
	public ResponseEntity<ResponseDTO> getAllUsers() {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Success");
		responseDTO.setData(userService.getAllUsers());
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/*
	 * To update user
	 *
	 * @param userid
	 * 
	 * @param name return successfully updated
	 */
	@PostMapping(value = "/updateUser", produces = "application/json")
	public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Success");
		responseDTO.setData(userService.updateUser(userDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/*
	 * To delete user
	 *
	 * @param userid
	 * 
	 * @param name return successfully deleted
	 */
	@PostMapping(value = "/deleteUser", produces = "application/json")
	public ResponseEntity<ResponseDTO> deleteUser(@RequestBody UserDTO userDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Success");
		responseDTO.setData(userService.deleteUser(userDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
