package com.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Employee;
import com.util.DatabaseUtil;
import com.util.QueryUtil;


public class DatabaseService {
	
	
	DatabaseUtil databaseUtil = new DatabaseUtil();
public void insertEmployee(Employee employee) throws SQLException{
	//System.out.println("insert called");
	try
	(Connection connection = databaseUtil.getConnection();
			PreparedStatement preparedStatement =connection.prepareStatement(QueryUtil.insertEmployeeQuery());){
			
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getEmployeeAddress());
			preparedStatement.setDouble(3, employee.getEmployeeSalery());
			
			
			int rows =preparedStatement.executeUpdate();
			
			if(rows>0) {
				System.out.println("Record created successfully");
			}else {
				System.out.println("Insert Record failed");
			}
			
}
	
	
}

public void getAllEmployees() throws SQLException {
	try(Connection connection =databaseUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery());){
		while(resultSet.next()) {
			printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
					resultSet.getString("EMPLOYEE_NAME"),
					resultSet.getString("EMPLOYEE_ADDRESS"),
					resultSet.getDouble("EMPLOYEE_SALARY")
					));
		
			
		}
	
	}
}
	private void printEmployee(Employee employee) {
		System.out.println("Employee id : "+ employee.getEmployeeId());
		System.out.println("Employee name : "+employee.getEmployeeName());
		System.out.println("Employee name : "+employee.getEmployeeAddress());
		System.out.println("Employee name : "+employee.getEmployeeSalery());
		System.out.println("..............................................");
	}
	
	
	public boolean getEmployeeById(int id) throws SQLException {
		
		boolean isFound = false;
		try(Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery(QueryUtil.selectEmployeeById(id));
				){
			if(resultSet.next()) {
				isFound = true;
				printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
						resultSet.getString("EMPLOYEE_NAME"),
						resultSet.getString("EMPLOYEE_ADDRESS"),
						resultSet.getDouble("EMPLOYEE_SALARY")
						));
			}else {
				System.out.println("Record not found for id "+id);
			}
		}
		return isFound;
	}
	
	public void deleteEmployeeById(int amployeeId) throws SQLException {
		
		try(Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();){
		int rows = statement.executeUpdate(QueryUtil.deleteEmployeeById(amployeeId));
		
		if(rows>0) {
			System.out.println("Record successfully deleted");
		}else {
			System.out.println("Something went wrong");
		}
		}
	}
	
	public void updateEmployee(Employee employee) throws SQLException {
		try(Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.updateEmployeeQuery(employee.getEmployeeId()))){
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getEmployeeAddress());
			preparedStatement.setDouble(3, employee.getEmployeeSalery());
			
			
			int rows = preparedStatement.executeUpdate();
			if(rows > 0) {
				System.out.println("record updated successfully");
			}else {
				System.out.println("failed update record");
			}
		}
	}
}
