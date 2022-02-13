package com.mygarden.demo.dao;

import java.util.List;

import com.mygarden.demo.DTO.PlantDTO;



public interface PlantDAO {
	public List<PlantDTO> getAllPlants();
	public List<PlantDTO> getUserPlants(long id);
	int addUserPlant(long userId, long plantId);
	int addNewPlant(PlantDTO plant);
	int updatePlant(PlantDTO plant);
}
