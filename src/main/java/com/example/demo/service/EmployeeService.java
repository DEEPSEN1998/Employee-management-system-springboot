package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
	EmployeeRepository empRepo;
    
    public List<Employee> getAllEmp(){
    	  return empRepo.findAll();
    }
    
    public boolean saveEmployee(Employee emp) {
		try {
			Employee savedEmp = empRepo.save(emp);
			
			if(savedEmp != null) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
    
    public void deleteEmpById(int id) {
        // Find the student by ID
        Employee emp = empRepo.findById(id).get();
        // Delete the student
        empRepo.delete(emp);;
    } 
    
    public Employee updateEmp(int id, Employee updatedEmployee) {
        // Find the employee by ID
        Employee emp = empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        // Update the employee's details
        emp.setName(updatedEmployee.getName());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setDesignation(updatedEmployee.getDesignation());
        emp.setSalary(updatedEmployee.getSalary());

        // Save the updated employee
        return empRepo.save(emp);
    }
    
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = empRepo.findById(id);
            return employee.get();
        
    }
    
    
    
}

