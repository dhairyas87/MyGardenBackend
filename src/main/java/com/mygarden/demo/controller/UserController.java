package com.mygarden.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygarden.demo.DTO.PlantDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	/*
	 * @Autowired UserRepository userRepository;
	 */
	@GetMapping("/userPlants/{id}")
	public ResponseEntity<List<PlantDTO>> getAllPlants(@PathVariable Long id) {
		List<PlantDTO> plants = null;
		

		return new ResponseEntity<List<PlantDTO>>(plants, HttpStatus.OK);
	}
}
