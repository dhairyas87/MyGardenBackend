package com.mygarden.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygarden.demo.DTO.PlantDTO;
import com.mygarden.demo.dao.PlantDAO;

@Service
public class PlantService {

	@Autowired
	PlantDAO plantDao;

	public List<PlantDTO> getAllPlants() {
		List<PlantDTO> plantDTOList = plantDao.getAllPlants();
		return plantDTOList;
	}
	
	public List<PlantDTO> getUserPlants(long id) {
		List<PlantDTO> plantDTOList = plantDao.getUserPlants(id);
		return plantDTOList;
	}
	public void addUserPlant(long userId, long plantId) {
		plantDao.addUserPlant(userId, plantId);
	}
	public void addNewPlant(PlantDTO plant) {
		plantDao.addNewPlant(plant);
	}
	
	public void updatePlant(PlantDTO plant) {
		plantDao.updatePlant(plant);
	}
	
}
