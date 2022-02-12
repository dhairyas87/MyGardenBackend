package com.mygarden.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
