package com.example.demo.service;

import com.example.demo.model.Division;
import com.example.demo.model.Employees;
import com.example.demo.repository.DivisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionService {

    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    public Optional<Division> findById(Long id) {
        return divisionRepository.findById(id);
    }

    public Optional<Division> deleteById(Long id) {
        divisionRepository.deleteById(id);
        return Optional.empty();
    }

    public Division save(Division division) {
        return divisionRepository.save(division);
    }
}
