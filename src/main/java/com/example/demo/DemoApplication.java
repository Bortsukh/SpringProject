package com.example.demo;

import com.example.demo.dao.AnimalDao;
import com.example.demo.dao.BreedDao;
import com.example.demo.dao.OwnerDao;
import com.example.demo.model.Animal;
import com.example.demo.model.Breed;
import com.example.demo.model.Owner;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		BreedDao dao = ctx.getBean(BreedDao.class);
//		dao.createBreed(new Breed(2L, "ivan"));
//		dao.delete(2);
		AnimalDao animalDao = ctx.getBean(AnimalDao.class);
//		animalDao.createAnimal(new Animal(2L, "Hex", 3.5, 4L));
		OwnerDao ownerDao = ctx.getBean(OwnerDao.class);
//		ownerDao.createOwner(new Owner(2L, "Stan", 1L));
	}
}