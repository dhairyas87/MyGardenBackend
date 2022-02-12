package com.mygarden.demo.dao;

import java.util.List;

import com.mygarden.demo.DTO.PlantDTO;



public interface PlantDAO {
	public List<PlantDTO> getAllPlants();
	public List<PlantDTO> getUserPlants(long id);
	void addUserPlant(long userId, long plantId);
	void addNewPlant(PlantDTO plant);
}
