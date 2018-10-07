package co.edu.udistrital.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.dto.UserDTO;
import co.edu.udistrital.entity.UserEntity;
import co.edu.udistrital.service.inter.IUserService;

@Controller
@RestController
@RequestMapping("/SGD/v1.0")
public class UserController {

	@Autowired
	IUserService userService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/users")
	public ResponseEntity<UserDTO[]> getAllUsers() {
		return new ResponseEntity<>(modelMapper.map(userService.findAll(), UserDTO[].class), HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserDTO> save(@RequestBody(required = true) UserDTO user) {
		return new ResponseEntity<>(
				modelMapper.map(userService.save(modelMapper.map(user, UserEntity.class)), UserDTO.class),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserDTO> update(@RequestBody(required = true) UserDTO user) {
		return new ResponseEntity<>(
				modelMapper.map(userService.update(modelMapper.map(user, UserEntity.class)), UserDTO.class),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
	}
}