package com.example.demo.dao;

import com.example.demo.model.Animal;
import com.example.demo.model.Owner;

import java.util.List;

public interface OwnerDao {
    void createOwner(Owner owner);
    Owner getOwnerById(long ownerId);
    Owner getOwnerByName(String ownerNick);
    void updateOwnerById(Owner owner);
    void delete(long ownerId);
    long count();
    List<Animal> getAllAnimals(String nickOwner);
}
