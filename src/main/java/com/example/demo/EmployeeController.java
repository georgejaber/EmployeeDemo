package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/Employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("/Employee/returnAll")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
    }

    @PostMapping("/Employees")
    public ResponseEntity<String> addEmployees(@Valid @RequestBody List<Employee> employees) {
        return new ResponseEntity<>(service.addEmployees(employees),HttpStatus.CREATED);
    }

    @PutMapping("/Employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@Valid @RequestBody Employee employee)
    {
        return new ResponseEntity<>(service.updateEmployee(id,employee),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Employee/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        return new ResponseEntity<>(service.deleteEmployee(id),HttpStatus.OK);

    }
    @GetMapping("Employee/returnAll/{PageNumber}/{PageSize}/{SortBy}/{Direction}")
    public ResponseEntity<Page<Employee>> PagingAndSorting(@PathVariable int PageNumber, @PathVariable int PageSize, @PathVariable String SortBy, @PathVariable String Direction)
    {
        return new ResponseEntity<>(service.PagingAndSorting(PageNumber,PageSize,Direction,SortBy),HttpStatus.OK);
    }

}
