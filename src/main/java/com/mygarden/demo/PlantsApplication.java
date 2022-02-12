package com.mygarden.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlantsApplication {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PlantsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlantsApplication.class, args);
	}

/*	@Bean
	  public CommandLineRunner demo(PlantRepository plantrepository,UserRepository userRepository) {
	    return (args) -> {
	      // save a few plants
	      
	     Plant p1 = new Plant("Jack1", "temp1","Red");
	     Plant p2 =  new Plant("Jack2", "temp2","Red");
	     Plant p3 = new Plant("Jack3", "temp3","Red");
	     Plant p4 = new Plant("Jack4", "temp4","Red");
	     Plant p5 = new Plant("Jack5", "temp5","Red");
	     plantrepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	      User user1 = new User("Dhairya", "Admin");
	      User user2 =  new User("Aastha", "User");
	      
	      user1.getPlants().addAll(Arrays.asList(p1,p2,p3));
	      
	      user2.getPlants().addAll(Arrays.asList(p1,p2,p4));
	      userRepository.saveAll(Arrays.asList(user1,user2));
	      
	      // fetch all plants
	      log.info("plants found with findAll():");
	      log.info("-------------------------------");
	      for (Plant plant : plantrepository.findAll()) {
	        log.info(plant.toString());
	      }
	      log.info("");

	   
	    }*/

}

