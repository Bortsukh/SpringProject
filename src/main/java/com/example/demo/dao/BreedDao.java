package com.example.demo.dao;

import com.example.demo.model.Breed;

public interface BreedDao {
    void createBreed(Breed breed);
    Breed getBreedById(long id_breed);
    void updateBreedById(long id_breed, String name);
    void delete(long id_breed);
    int count();
}