package com.example.demo.controller;

import com.example.demo.model.Division;
import com.example.demo.service.DivisionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/main/divisions")
@CrossOrigin()
public class DivisionController {
    private DivisionService repository;

    public DivisionController(DivisionService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<Division> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/main/divisions/{id}")
    public Optional<Division> getById(@PathVariable Long id) {
        return repository.findById(id).stream().findFirst();
    }

    @DeleteMapping("/main/divisions/{id}")
    public Optional<Division> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PostMapping("")
    public Division insertEmployees(@RequestBody Division division) {
        return repository.save(division);
    }
}
