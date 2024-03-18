package com.util;

public class QueryUtil {
	public static String insertEmployeeQuery() {
		return "INSERT INTO EMPLOYEE (EMPLOYEE_NAME, EMPLOYEE_ADDRESS, EMPLOYEE_SALARY) VALUES (?,?,?)";
	}

	public static String selectAllEmployeeQuery() {
		return "SELECT * FROM EMPLOYEE";
	}

	public static String selectEmployeeById(int employeeId) {
		return "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = " + employeeId;
	}

	public static String deleteEmployeeById(int employeeId) {
		return "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = " + employeeId;
	}
	public static String updateEmployeeQuery(int employeeId) {
		return "update employee set employee_name = ?, employee_address = ?, employee_salary = ? where employee_id = " + employeeId ;
		}
	
}
