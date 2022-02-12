package com.mygarden.demo.dao;

import java.util.List;

import com.mygarden.demo.DTO.PlantDTO;



public interface PlantDAO {
	public List<PlantDTO> getAllPlants();
	public List<PlantDTO> getUserPlants(long id);
}
