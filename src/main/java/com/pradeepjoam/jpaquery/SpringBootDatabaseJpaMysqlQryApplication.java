package com.pradeepjoam.jpaquery;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pradeepjoam.jpaquery.controller.EmployeeController;

@SpringBootApplication
public class SpringBootDatabaseJpaMysqlQryApplication implements CommandLineRunner {

	@Autowired
	EmployeeController employeeController;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatabaseJpaMysqlQryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner inputKeybord=new Scanner(System.in);
		System.out.println("********* Login Panel *********");
		System.out.println("User Name - > ");
		String userName=inputKeybord.next();
		System.out.println("Password  - > ");
		String password=inputKeybord.next();
		String response;
		int key;
		
		if(userName.equals("Pradeep")&&password.equals("Joam"))
		{
			do {
				System.out.println("1.Register Employee Data without Java Collection -- (Iterable) ");
				System.out.println("2.Register Employee Data with Collection -- (Iterable) ");
				
				System.out.println("3.Retrieve Employee Data using By Id ");
				System.out.println("4.Retrieve Employee Data using By Id with Collection -- (Iterable) ");
				System.out.println("5.Retrieve All Employee Data with Collection -- (Iterable) ");
				
				System.out.println("6.Delete Employee Data using By Id ");
				System.out.println("7.Delete Employee Data using By Id with Collection -- (Iterable) ");
				System.out.println("8.Delete All Employee Data with Collection -- (Iterable) ");
				
				System.out.println("9.Update Employee Data using By Id with Verify your Id  ");
				System.out.println("10.Project Info");
				System.out.println("Your Choice is --> ");
				key=inputKeybord.nextInt();
				switch (key) {
				case 1:
					employeeController.createEmployeeData();
					break;
				case 2:
					employeeController.createEmployeeDataUsingCollection();				
					break;
				case 3:
					employeeController.getEmployeeDataById();
					break;
				case 4:
					employeeController.getEmployeeDataByIdCollection();
					break;
				case 5:
					employeeController.getAllEmployeeData();	
					break;
				case 6:
					employeeController.deleteEmployeeDataById();
					break;
				case 7:
					employeeController.deleteEmployeeDataByIdUsingCollection();
					break;
				case 8:
					employeeController.deleteEmployeeAllData();
					break;
				case 9:
					employeeController.updateEmployeeDataById();
					break;
				case 10:
					employeeController.projectInfo();	
					break;

				default:
					System.out.println("Your wrong choice -- > Try Again");
					break;
				}
				System.out.println("Do you want to contine your process -- > Yes/No -- > ");
				response=inputKeybord.next();
			}while(response.equals("Yes")||response.equals("yes")||response.equals("YES"));
			
		}
		else
		{
			System.out.println("Unauthorized Person");
			System.exit(0);
		}
		
		inputKeybord.close();
		
		
	}

}
