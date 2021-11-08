package com.example.demo.controller;

import com.example.demo.dao.BreedDao;
import com.example.demo.model.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreedController {

    @Autowired
    BreedDao breedDao;

    @GetMapping("breed/{id}")
    public String getBreedNameById(@PathVariable long id) {
      return breedDao.getBreedById(id).getNameBreed();
    }

    @PostMapping("breed/add")
    public void createBreed(@RequestBody Breed request) {
        breedDao.createBreed(request);
    }

    @PutMapping("breed/update")
    public void updateBreed(@RequestParam long id, @RequestParam String name) {
        breedDao.updateBreedById(id, name);
    }

    @DeleteMapping("breed/delete/{id}")
    public void deleteBreed(@PathVariable long id) {
        breedDao.delete(id);
    }

    @GetMapping("breed/count")
        public int countBreed() {
        return breedDao.count();
    }
}