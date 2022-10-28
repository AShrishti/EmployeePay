package com.bridgelabz.EmployeePay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class EmployeeService {
	private List<Employee> employeePayRollList;

	static Employee setEmployeeDetails() {

		Employee emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Emter Employee Name");
		emp.setName(sc.nextLine());
		System.out.println("Emter Employee Salary");
		emp.setSalary(sc.nextDouble());
		System.out.println("Emter Employee Gender");
		emp.setGender(sc.next());

		return emp;
	}

	public void CreatePayRollData() throws IOException, ClassNotFoundException, ParseException {

		employeePayRollList = new ArrayList<>();
		for (int i = 1; i < 2; i++) {
			Employee emp = EmployeeService.setEmployeeDetails();
			DbConnection Dbconn = new DbConnection();
			Dbconn.insertEmployee(emp);
			FileIOEmployee.fileWriteOperation(emp);
			employeePayRollList.add(emp);
			Scanner sc = new Scanner(System.in);
			System.out.println("Add more employee , enter Y/N");
			char choice = sc.next().toLowerCase().charAt(0);
			if (choice == 'y')
				i = 0;
		}

	}

	public void getEmployeeDetails() {
		// employeePayRollList.forEach(employee ->
		// employee.getName()+employee.getSalary())

	}

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, ParseException, java.text.ParseException {
		EmployeeService createEmp = new EmployeeService();
		createEmp.CreatePayRollData();

		FileIOEmployee.readJSONdata();
	}

}
