package com.pradeepjoam.jpaquery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pradeepjoam.jpaquery.entities.Employee;
import com.pradeepjoam.jpaquery.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	Employee employee;
	
	Scanner inputKeybord=new Scanner(System.in);

	public void createEmployeeData()
	{

		System.out.print("How Many Employee Register -- > ");
	//	Scanner inputKeybord=new Scanner(System.in);
		int empSize=inputKeybord.nextInt();
		inputKeybord.nextLine();
		//Employee employee;
		for(int i=0;i<empSize;i++)
		{
			//employee=new Employee();
			System.out.print("Employee Name -- > ");
			employee.setEmpName(inputKeybord.nextLine());
			System.out.print("Employee Email Id -- > ");
			employee.setEmpEmail(inputKeybord.next());
			System.out.print("Employee Salary -- > ");
			employee.setEmpSalary(inputKeybord.nextInt());
			inputKeybord.nextLine();
			System.out.print("Employee City -- > ");
			employee.setEmpCity(inputKeybord.nextLine());
			System.out.println("\n"+employeeService.createEmployeeData(employee));
		}
		System.out.println("Successfully "+empSize+" Employee Registered");
		inputKeybord.close();
		
		
	}

	public void createEmployeeDataUsingCollection() {
		List<Employee> employeeList=new ArrayList<Employee>();

		System.out.print("How Many Employee Register -- > ");
		//Scanner inputKeybord=new Scanner(System.in);
		int empSize=inputKeybord.nextInt();
		inputKeybord.nextLine();
		//Employee employee;
		for(int i=0;i<empSize;i++)
		{
			//employee=new Employee();
			System.out.print("Employee Name -- > ");
			employee.setEmpName(inputKeybord.nextLine());
			System.out.print("Employee Email Id -- > ");
			employee.setEmpEmail(inputKeybord.next());
			System.out.print("Employee Salary -- > ");
			employee.setEmpSalary(inputKeybord.nextInt());
			inputKeybord.nextLine();
			System.out.print("Employee City -- > ");
			employee.setEmpCity(inputKeybord.nextLine());
			employeeList.add(employee);
			//employeeService.createEmployeeData(employee);
			//System.out.println("\n"+employeeService.createEmployeeData(employee));
		}
		Iterable<Employee> iterableEmployee=employeeService.createEmployeeDataUsingCollection(employeeList);
		for(Employee empData:iterableEmployee)
		{
			System.out.println(empData);
		}
		
		System.out.println("Successfully "+empSize+" Employee Registered");
		inputKeybord.close();
		
	}
	
	public void getEmployeeDataById() {
		System.out.println("Put Employee Id -- > ");
		int empId=inputKeybord.nextInt();
		
		Employee empData= employeeService.getEmployeeDataById(empId);
		System.out.println(empData);
		inputKeybord.close();
	}


	public void getEmployeeDataByIdCollection() {
		List<Integer> empList=new ArrayList<Integer>();
		System.out.print("How Many Employee find -- > ");
		//Scanner inputKeybord=new Scanner(System.in);
		int empSize=inputKeybord.nextInt();
		for(int i=0;i<empSize;i++)
		{
			System.out.println("Put Employee Id -- > ");
			empList.add(inputKeybord.nextInt());
			//System.out.println();
		}
		Iterable<Employee> empDataList= employeeService.getEmployeeDataByIdCollection(empList);
		empDataList.forEach(empDataListView->System.out.println(empDataListView));
		inputKeybord.close();
		
	}
	
	public void getAllEmployeeData()
	{
		Iterable<Employee> empAllDataList= employeeService.getAllEmployeeData();
		empAllDataList.forEach(System.out::println);
	}
	

	public void deleteEmployeeDataByIdUsingCollection() {
		
		  List<Employee> empListDel=new ArrayList<Employee>();
		  
		  System.out.print("How Many Employee Data Delete -- > "); //Scanner
		  inputKeybord=new Scanner(System.in); int empSize=inputKeybord.nextInt();
		  for(int i=0;i<empSize;i++) {
		  
		  System.out.println("Put Employee Id Do You Want To Delete-- > "); 
		  //Employee emp=new Employee(); 
		  employee.setEmpId(inputKeybord.nextInt());
		  empListDel.add(employee);
		  
		  } 
		  employeeService.deleteEmployeeDataByIdUsingCollection(empListDel);
		 
		
		inputKeybord.close();
		
	}
	

	public void deleteEmployeeDataById() {

		//Employee emp=new Employee();
		System.out.println(" Do You Want To Delete Employee Data -- > Yes/No");
		String res=inputKeybord.next();
		if(res.equals("yes")||res.equals("Yes")||res.equals("YES"))
		{
			System.out.println("Enter Employee Id -- > ");
			employee.setEmpId(inputKeybord.nextInt());//data deleted by Id, you can change data value to delete data
			employeeService.deleteEmployeeDataById(employee);
			System.out.println("-- >  Employee Data Deleted");
			
		}
		else
		{
			System.out.println("Thanks Your data Not deleted -- > Response id - "+res);
		}
		inputKeybord.close();
	}
	
    public void deleteEmployeeAllData() 
    {
		
		System.out.println(" Do You Want To Delete All Employee Data -- > Yes/No");
		String res=inputKeybord.next();
		if(res.equals("yes")||res.equals("Yes")||res.equals("YES"))
		{
			employeeService.deleteEmployeeAllData();
			System.out.println("All Data Deleted --> oh ho!!!");
		}
		else
		{
			System.out.println("Thanks Your data Not deleted -- > Response id - "+res);
		}
		inputKeybord.close();
	}
	
	

	public void updateEmployeeDataById() {
	
		System.out.println("Do You Want To Update Employee Data -- > Yes/No");
		String res=inputKeybord.next();
		if(res.equals("yes")||res.equals("Yes")||res.equals("YES"))
		{
			System.out.println("Enter Employee Id -- Verify Your Data -- > ");
			int empId=inputKeybord.nextInt();//data deleted by Id, you can change data value to delete data
			inputKeybord.nextLine();
			boolean status=employeeService.verifyEmployeeDataById(empId);
			if(status)
			{
				System.out.println("Put a Updated info  -- > ");
				//Employee employee=new Employee();
				System.out.print("Employee Name -- > ");
				employee.setEmpName(inputKeybord.nextLine());
				System.out.print("Employee Email Id -- > ");
				employee.setEmpEmail(inputKeybord.next());
				System.out.print("Employee Salary -- > ");
				employee.setEmpSalary(inputKeybord.nextInt());
				inputKeybord.nextLine();
				System.out.print("Employee City -- > ");
				employee.setEmpCity(inputKeybord.nextLine());
				System.out.println("\n"+employeeService.createEmployeeData(employee));
				System.out.println("--*** Employee Data Updated *--");
	
				
			}
			else
			{
				System.out.println("Employee Does Not Exist");
			}
			
		}
		else
		{
			System.out.println("Thanks Your data is Not Update -- > Response is - "+res);
		}
		inputKeybord.close();
		
	}

	public void projectInfo() {
		System.out.println("************* Welcome *************");
		System.out.println("Created By   :- Pradeep Joam");
		System.out.println("Profile      :- Sr.Java Developer");
		System.out.println("Email/Mobile :- pradeepjoam@gmail.com/+919815167031");
		System.out.println("Project Info.:- This is Basic spring boot CRUD opration using CrudRepository.\nImplatement all method step by step using switch case");
		System.out.println("************* Thank You *************");
		
	}

	
	
	
	

}
