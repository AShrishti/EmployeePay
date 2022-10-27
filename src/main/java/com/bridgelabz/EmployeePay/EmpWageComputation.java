package com.bridgelabz.EmployeePay;

import java.util.Random;

/**
 * Calculating the Monthly Employee Wage
 *
 */
public class EmpWageComputation {

	public static void main(String[] args) {
		int WorkingHours = 0;
		// int isPresent = 1;
		// int isPartTime = 2;
		int WagePerHour = 20;
		int DailyEmpWage = 0;
		int TotalMonthlyWorkingHours = 0;
		int TotalWorkingDays = 0;
		int TotalEmpWage = 0;
		int count = 0;

		System.out.println("Welcome to Employee Wage Computation Program");
		for (int i = 1; i <= 30; i++) {
			Random random = new Random();
			int randomcheck = random.nextInt(3);

			switch (randomcheck) {
			case (1): {
				System.out.println("Employee is Present");
				WorkingHours = 8;
				count++;
				break;
			}
			case (2): {
				System.out.println("Employee is Present,but worked for PartTime");
				WorkingHours = 4;
				count++;
				break;
			}
			case (0): {
				System.out.println("Employee is Absent");
				DailyEmpWage = 0;
				break;
			}

			}
			TotalMonthlyWorkingHours += WorkingHours;
			TotalWorkingDays += count;
		}

		if (TotalMonthlyWorkingHours >= 100 && TotalWorkingDays >= 20) {
			TotalEmpWage = TotalMonthlyWorkingHours * WagePerHour;
			System.out.println("Total Monthly Employee Wage of Employee is :" + TotalEmpWage);
		} else
			System.out.println("Total monthly Working hours not met");
	}
}
