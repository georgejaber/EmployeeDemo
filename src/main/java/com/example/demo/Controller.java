package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    EmployeeRepository repository;

    public Controller(EmployeeRepository repository) {
        this.repository=repository;
    }

    @GetMapping("/save")
    public void save()
    {
        repository.save(new Employee("momen","mafarjeh","momen48@gmail.com"));
    }

    @GetMapping("/findall")
    public List<Employee> findall()
    {
        return repository.findAll();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        repository.deleteById(id);
        return "deleted";
    }
}
