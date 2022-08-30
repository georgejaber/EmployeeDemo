package com.example.demo;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String addEmployees(List<Employee> employees) {
        StringBuilder names = new StringBuilder();

             for (Employee employee : employees) {
                 names.append(employee.getFirst_name()).append(employee == employees.get(employees.size() - 1) ? "" : ", ");

             }

        repository.saveAll(employees);
        return "the Employee with the Names " +names + " have been add";
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public String deleteEmployee(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "the Employee with the ID " + id + " has been deleted";
        } else {
            return "the Employee with the ID " + id + " has not been found";
        }
    }
    public Employee updateEmployee(Long id,  Employee newEmployee) {

       return repository.findById(id).map(employee ->
       {
           employee.setFirst_name(newEmployee.getFirst_name());
           employee.setLast_name(newEmployee.getLast_name());
           employee.setEmail(newEmployee.getEmail());
           return repository.save(employee);
       }
       ).orElseThrow();

    }
}
