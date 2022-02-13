package com.mygarden.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygarden.demo.DTO.PlantDTO;
import com.mygarden.demo.services.PlantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/plant")
public class PlantsController {

	@Autowired
	PlantService plantService;

	@GetMapping("/getAllPlants")
	public ResponseEntity<List<PlantDTO>> getAllPlants() {
		List<PlantDTO> plants = plantService.getAllPlants();

		return new ResponseEntity<List<PlantDTO>>(plants, HttpStatus.OK);
	}

	@GetMapping("/getUserPlants/{id}")
	public ResponseEntity<List<PlantDTO>> getUserPlants(@PathVariable Long id) {
		List<PlantDTO> plants = plantService.getUserPlants(id);

		return new ResponseEntity<List<PlantDTO>>(plants, HttpStatus.OK);
	}

	@PostMapping("/addUserPlant/{userId}/{plantId}")
	public ResponseEntity addUserPlant(@PathVariable Long userId, @PathVariable Long plantId) {
		plantService.addUserPlant(userId, plantId);
		if (plantService.addUserPlant(userId, plantId) != 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addNewPlant")
	public ResponseEntity addNewPlant(@RequestBody PlantDTO plantDto) {
		if (plantService.addNewPlant(plantDto) != 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			/*
			 * Ideally this block should throw Internal Server Error with Proper Exception
			 * but due to time constraint 
			 * 
			 */
			
			 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatePlant")
	public ResponseEntity updatePlant(@RequestBody PlantDTO plantDto) {
		if (plantService.updatePlant(plantDto) != 0) {

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
