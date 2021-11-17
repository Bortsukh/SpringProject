package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Owner {

    private long ownerId;
    private String nickOwner;
    private long animalId;
    private String email;
}