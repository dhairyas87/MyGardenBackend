package com.mygarden.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mygarden.demo.DTO.PlantDTO;
import com.mygarden.demo.dao.PlantDAO;

@Repository
public class PlantDAOImpl implements PlantDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlantDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<PlantDTO> getAllPlants() {
		// TODO Auto-generated method stub
		try {

			return jdbcTemplate.query("SELECT * FROM PLANTS", new PlalntDTORowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info(
					"EmptyResultDataAccessException thrown while retrieving all Plants. Exception Details are : {} ",
					e.getMessage());
		}
		return Collections.emptyList();
	}

	@Override
	public List<PlantDTO> getUserPlants(long id) {
		try {

			return jdbcTemplate.query(
					"SELECT * FROM PLANTS P INNER JOIN PLANTS_USERS PU ON P.ID = PU.PLANT_ID WHERE PU.USER_ID = ? ",
					new PlalntDTORowMapper(), new Object[] { id });
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info(
					"EmptyResultDataAccessException thrown while retrieving all Plants. Exception Details are : {} ",
					e.getMessage());
		}
		return Collections.emptyList();

	}

	@Override
	public int addUserPlant(long userId, long plantId) {
		int insertedRowCount =0;
		try {
			 insertedRowCount = jdbcTemplate.update("INSERT INTO PLANTS_USERS (USER_ID,PLANT_ID) VALUES (?,?)",
					userId, plantId);

		} catch (DataAccessException e) {
			LOGGER.info("Error while adding a plnat for the user with Id {}.Exception Details are: {}", userId,
					e.getMessage());
			

		}
		return insertedRowCount;
	}
	
	@Override
	public int addNewPlant(PlantDTO plant) {
		// TODO Auto-generated method stub
		int insertedRowCount =0;
		try {
			 insertedRowCount = jdbcTemplate.update("INSERT INTO PLANTS (NAME,IMAGE,DESCRIPTION) VALUES (?,?,?)",
					plant.getName(),plant.getImage(),plant.getDescription());

		} catch (DataAccessException e) {
			LOGGER.info("Error while adding a plant to all Plant List {}.Exception Details are: {}", plant.getId(),
					e.getMessage());

		}
		return insertedRowCount;

	}
	
	@Override
	public int updatePlant(PlantDTO plant) {
		// TODO Auto-generated method stub
		
		int insertedRowCount =0;
		try {
			 insertedRowCount = jdbcTemplate.update("UPDATE PLANTS SET NAME =?,IMAGE=?,DESCRIPTION =? WHERE PLANTS.ID = ?",
					plant.getName(),plant.getImage(),plant.getDescription(),plant.getId());

		} catch (DataAccessException e) {
			LOGGER.info("Error while adding a plant to all Plant List {}.Exception Details are: {}", plant.getId(),
					e.getMessage());

		}
		return insertedRowCount;
		
	}


	static final class PlalntDTORowMapper implements RowMapper<PlantDTO> {

		public PlantDTO mapRow(ResultSet resultSet, int i) throws SQLException {
			PlantDTO plantDTO = new PlantDTO();

			plantDTO.setId(resultSet.getLong("ID"));
			plantDTO.setImage(resultSet.getString("IMAGE"));
			plantDTO.setDescription(resultSet.getString("DESCRIPTION"));
			plantDTO.setName(resultSet.getString("NAME"));

			return plantDTO;
		}
	}


	

	
}
