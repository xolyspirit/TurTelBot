package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    private final CityRepository repository;

    CityController(CityRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/city")
    public City greeting(@RequestParam(value = "name") String name,
                         @RequestParam(value = "message") String message) {
        return repository.save(new City(name, message));
    }
}
