package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmp();
        return ResponseEntity.ok(employees);
    }

    // Save an employee
    @PostMapping("/add")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
        boolean isSaved = employeeService.saveEmployee(emp);
        if (isSaved) {
            return ResponseEntity.ok("Employee saved successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to save employee");
        }
    }

    // Delete an employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmpById(id);
        return ResponseEntity.noContent().build();
    }

 // Update an employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee emp = employeeService.updateEmp(id, updatedEmployee);
        return ResponseEntity.ok(emp);
    }
  // find user by Id  
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return (employee);
    }
}
