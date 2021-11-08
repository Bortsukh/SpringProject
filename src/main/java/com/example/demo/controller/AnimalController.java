package com.example.demo.controller;

import com.example.demo.dao.AnimalDao;
import com.example.demo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @Autowired
    AnimalDao animalDao;

    @PostMapping("animal/add")
    public void createAnimal(@RequestBody Animal request) {
        animalDao.createAnimal(request);
    }

    @GetMapping("animal/{id}")
    public Animal getAnimalById(@PathVariable long id) {
        return animalDao.getAnimalById(id);
    }

    @PutMapping("animal/update")
    public void upadateAnimal(@RequestBody Animal animal) {
        animalDao.updateAnimal(animal);
    }

    @DeleteMapping("animal/delete/{id}")
    public void deleteAnimalById(@PathVariable long id) {
        animalDao.deleteAnimalById(id);
    }

    @GetMapping("animal/count")
    public long countAnimal() {
        return animalDao.count();
    }
}
