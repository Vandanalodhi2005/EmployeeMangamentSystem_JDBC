package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.model.Employee;
import com.server.DatabaseService;

public class MainClass {

	public static void main(String[] args) {
		DatabaseService databaseService = new DatabaseService();
		
		try(Scanner scanner = new Scanner(System.in);){
			
			boolean isRunning = true;
			while(isRunning) {
		System.out.println("Enter choice");
		System.out.println("1. Insert");
		System.out.println("2. Select All");
		System.out.println("3. Select employee by an Id");
		System.out.println("4. Delete employee");
		System.out.println("5. Update empoyee");
		System.out.println("6. Exit");
		
		
		int choice = Integer.parseInt(scanner.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter name , Address, Salary");
			
					databaseService.insertEmployee(new Employee(scanner.nextLine(),scanner.nextLine(), 
							Double.parseDouble(scanner.nextLine())));
					
			
			break;
			
	
		case 2:
			databaseService.getAllEmployees();
			
			break;
			
		case 3:
			System.out.println("Enter id of an employee");
			databaseService.getEmployeeById(Integer.parseInt(scanner.nextLine()));
			
			break;
			
		case 4:
			
			System.out.println("Enter id of an employee");
			databaseService.deleteEmployeeById(Integer.parseInt(scanner.nextLine()));
			
			
			break;
			
			
		case 5:
			System.out.println("Enter id of an employee");
			int updateId = Integer.parseInt(scanner.nextLine());
			boolean isFound = databaseService.getEmployeeById(updateId);
			
			if(isFound) {
				System.out.println("Enter name, address, salary");
				Employee employee = new Employee(updateId, scanner.nextLine(), scanner.nextLine(), Double.parseDouble(scanner.nextLine()));
				databaseService.updateEmployee(employee);
			}
			
			break;
			
		case 6:
			System.out.println("Thankyou  visit again");
			isRunning = false;
			break;

		default:
			System.out.println("Incorrect choice");
			break;
		}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Something went wrong "+ e);
		}
	}
}
