package com.pradeepjoam.jpaquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradeepjoam.jpaquery.dao.MysqlJpaRepoInterface;
import com.pradeepjoam.jpaquery.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	MysqlJpaRepoInterface mysqlJpaRepoInterface;
	
	
	public Employee createEmployeeData(Employee employee) {
		return mysqlJpaRepoInterface.save(employee);
		
	}

	public Iterable<Employee> createEmployeeDataUsingCollection(List<Employee> employeeList) {

		Iterable<Employee> empListData= mysqlJpaRepoInterface.saveAll(employeeList);
		return empListData;
	}

	public Iterable<Employee> getEmployeeDataByIdCollection(List<Integer> empList) {
		
		return mysqlJpaRepoInterface.findAllById(empList);
	}

	public Employee getEmployeeDataById(int empId) {
		
		
		return  mysqlJpaRepoInterface.findById(empId).orElse(new Employee());
	}

	public Iterable<Employee> getAllEmployeeData()
	{
		
		return mysqlJpaRepoInterface.findAll();
	}

	public void deleteEmployeeDataByIdUsingCollection(List<Employee> empListDel) {
		
		 mysqlJpaRepoInterface.deleteAll(empListDel);
	}

	public void deleteEmployeeDataById(Employee empId) 
	{
		//mysqlJpaRepoInterface.deleteById(empId.getEmpId());////data deleted by Id, you can change data value to delete data
		mysqlJpaRepoInterface.delete(empId);// both are method use to delete data first method special method to delete by Id and second is deleted by object
	}

	public void deleteEmployeeAllData() {
		mysqlJpaRepoInterface.deleteAll();
	}

	public boolean verifyEmployeeDataById(int empId) {
		
		return mysqlJpaRepoInterface.existsById(empId);
	}

	

}
