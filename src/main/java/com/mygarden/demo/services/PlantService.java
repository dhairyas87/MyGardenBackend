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
	public int  addUserPlant(long userId, long plantId) {
	return plantDao.addUserPlant(userId, plantId);
	}
	public int addNewPlant(PlantDTO plant) {
		return plantDao.addNewPlant(plant);
	}
	
	public int updatePlant(PlantDTO plant) {
		return plantDao.updatePlant(plant);
	}
	
}
