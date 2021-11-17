package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Animal {

    private long animalId;
    private String nickName;
    private double weight;
    private long breedId;
    private String place;
    private byte[] photo;
    private String event;
}