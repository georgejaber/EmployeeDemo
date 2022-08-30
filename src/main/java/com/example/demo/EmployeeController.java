package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/Employee/returnAll")
    public List<Employee> findAll() {
        return service.findAll();
    }

    @PostMapping("/Employees")
    public String addEmployees(@RequestBody List<Employee> employees) {
        return service.addEmployees(employees);
    }

    @PutMapping("/Employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
    {
        return service.updateEmployee(id,employee);
    }

    @DeleteMapping("/Employee/{id}")
    public String delete(@PathVariable Long id) {

        return service.deleteEmployee(id);

    }

}
