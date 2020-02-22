package me.kay.controller;

import me.kay.entities.Pet;
import me.kay.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    PetMapper petMapper;

    @GetMapping(value = "/pet/{id}")
    public Pet allPet(@PathVariable("id") int id){
        return petMapper.getPetById(id);
    }
}
