package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employee_Table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Emp_Name",nullable=false)
	private String Name;
	@Column(name="Emp_Email")
	private String Email;
	@Column(name="Emp_Designation")
	private String Designation;
	@Column(name="Emp_salary")
	private int salary;
	//parameterized constructor
	public Employee(int id, String name, String email, String designation, int salary) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		Designation = designation;
		this.salary = salary;
	}
	//No arguments constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", Email=" + Email + ", Designation=" + Designation
				+ ", salary=" + salary + "]";
	}
}
