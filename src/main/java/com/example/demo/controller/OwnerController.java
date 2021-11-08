package com.example.demo.controller;

import com.example.demo.dao.OwnerDao;
import com.example.demo.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    @Autowired
    OwnerDao ownerDao;

    @PostMapping("owner/add")
    public void createOwner(@RequestBody Owner owner) {
        ownerDao.createOwner(owner);
    }

    @GetMapping("owner/{id}")
    public Owner getOwnerById(@PathVariable long id) {
        return ownerDao.getOwnerById(id);
    }

    @PutMapping("owner/update")
    public void updateOwner(@RequestBody Owner owner) {
       ownerDao.updateOwnerById(owner);
    }

    @DeleteMapping("owner/delete/{id}")
    public void deleteOwner(@PathVariable long id) {
        ownerDao.delete(id);
    }

    @GetMapping("owner/count")
    public long countOwner() {
        return ownerDao.count();
    }
}
