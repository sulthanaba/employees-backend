package com.example.demo.service;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeesRepository employeesRepositories;

    public EmployeeService(EmployeesRepository employeesRepositories) {
        this.employeesRepositories = employeesRepositories;
    }

    public List<Employees> findAll() {
        return employeesRepositories.findAll();
    }

    public Optional<Employees> findById(Long id) {
        return employeesRepositories.findById(id);
    }

    public Optional<Employees> deleteById(Long id) {
        employeesRepositories.deleteById(id);
        return Optional.empty();
    }

    public Employees save(Employees employees) {
        if(employees.getId() == null){
            return employeesRepositories.save(employees);
        }else{
            Employees employeesToUpdate = employeesRepositories.getOne(employees.getId());
            employeesToUpdate.setNik(employees.getNik());
            employeesToUpdate.setName(employees.getName());
            employeesToUpdate.setDivisionId(employees.getDivisionId());
            employeesToUpdate.setPositionId(employees.getPositionId());
            employeesToUpdate.setLastPosition(employees.getLastPosition());
            employeesToUpdate.setType(employees.getType());
            return employeesRepositories.save(employeesToUpdate);
        }
    }
}
