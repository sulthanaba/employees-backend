package com.example.demo.controller;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/main/employees")
@CrossOrigin()
public class EmployeesController {
    private EmployeeService repository;

    public EmployeesController(EmployeeService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<Employees> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("main/employees/{id}")
    public Optional<Employees> getById(@PathVariable Long id) {
        return repository.findById(id).stream().findFirst();
    }

    @DeleteMapping("main/employees/{id}")
    public Optional<Employees> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PostMapping("")
    public Employees insertEmployees(@RequestBody Employees employees) {
        return repository.save(employees);
    }
}
