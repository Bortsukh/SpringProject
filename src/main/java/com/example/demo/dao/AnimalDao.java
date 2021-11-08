package com.example.demo.dao;

import com.example.demo.model.Animal;

public interface AnimalDao {

    void createAnimal(Animal animal);
    Animal getAnimalById(long animalId);
    void updateAnimal(Animal animal);
    void deleteAnimalById(long animalId);
    long count();
}
