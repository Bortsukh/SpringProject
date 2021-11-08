package com.example.demo.dao;

import com.example.demo.model.Owner;

public interface OwnerDao {
    void createOwner(Owner owner);
    Owner getOwnerById(long ownerId);
    void updateOwnerById(Owner owner);
    void delete(long ownerId);
    long count();
}
