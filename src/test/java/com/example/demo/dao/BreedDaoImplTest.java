package com.example.demo.dao;

import com.example.demo.model.Breed;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(BreedDaoImpl.class)
class BreedDaoImplTest {

    private static String EXPECTED_NAME = "HHHHH";
    private static int EXPECTED_BREED_ID_FOR_HUSKY = 2;
    private static String EXPECTED_NAME_HUSKY = "HUSKY";

    @Autowired
    private BreedDaoImpl breedDao;

    @Test
    void createBreed() {
        breedDao.createBreed(new Breed(4,"HHHHH"));
        String name= breedDao.getBreedById(4).getNameBreed();
        assertEquals(EXPECTED_NAME, name);
    }

    @Test
    void getBreedById() {
        Breed breed = breedDao.getBreedById(2);
        assertEquals(EXPECTED_NAME_HUSKY, breed.getNameBreed());
        assertEquals(EXPECTED_BREED_ID_FOR_HUSKY, breed.getBreedId());
    }

    @Test
    void updateBreed() {

    }

    @Test
    void delete() {
    }

    @Test
    void count() {
    }
}