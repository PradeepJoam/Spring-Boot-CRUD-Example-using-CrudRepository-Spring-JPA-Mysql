package com.pradeepjoam.jpaquery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="TechEmp")
@Component
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer empId;
	
	@Column
	private String empName;
	
	@Column
	private String empEmail;
	
	@Column
	private String empCity;
	
	@Column
	private Integer empSalary;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empEmail, String empCity, Integer empSalary) {
		
		this.empName = empName;
		this.empEmail = empEmail;
		this.empCity = empCity;
		this.empSalary = empSalary;
	}



	public Integer getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public String getEmpCity() {
		return empCity;
	}

	public Integer getEmpSalary() {
		return empSalary;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empCity=" + empCity
				+ ", empSalary=" + empSalary + "]";
	}
	
	

}
