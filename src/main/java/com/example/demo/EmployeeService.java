package com.example.demo;


import com.example.demo.Exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String addEmployees(List<Employee> employees) {
        try {
            StringBuilder names = new StringBuilder();
            for (Employee employee : employees) {
                names.append(employee.getFirst_name()).append(employee == employees.get(employees.size() - 1) ? "" : ", ");

            }
            repository.saveAll(employees);

            return "the Employee with the Names " + names + " have been add";
        } catch (Exception e) {
            throw new AppException("Couldn't Save All", HttpStatus.BAD_REQUEST);
        }
    }

    public List<Employee> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new AppException("Couldn't Find All",HttpStatus.NOT_FOUND);
        }
    }

    public Employee findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new AppException("Couldn't Find Employee",HttpStatus.NOT_FOUND));

    }

    public String deleteEmployee(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "the Employee with the ID " + id + " has been deleted";
        } else {
            throw new AppException("Couldn't Find Employee",HttpStatus.NOT_FOUND);
        }
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new AppException("Couldn't Find Employee",HttpStatus.NOT_FOUND));

        try {
            employee.setFirst_name(newEmployee.getFirst_name());
            employee.setLast_name(newEmployee.getLast_name());
            employee.setEmail(newEmployee.getEmail());
            return repository.save(employee);
        } catch (Exception e) {
            throw new AppException("Couldn't update Employee",HttpStatus.BAD_REQUEST);
        }

    }


}
