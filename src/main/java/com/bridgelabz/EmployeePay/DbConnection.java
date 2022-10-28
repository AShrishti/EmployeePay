package com.bridgelabz.EmployeePay;

import java.sql.*;

public class DbConnection {

	// public static void main(String[] args) {
	public void insertEmployee(Employee employee) throws ClassNotFoundException {
		Connection con = null;
		// PreparedStatement preparedStmt = null;
		int emp_id = -1;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "ROOT");
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();

			String query = " insert into employee_payroll ( name, salary, gender) " + " values ( ?, ?, ?) ";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, employee.getName().toLowerCase());
			preparedStmt.setDouble(2, employee.getSalary());
			preparedStmt.setString(3, employee.getGender());

			int rowaffected = preparedStmt.executeUpdate();

			System.out.println(rowaffected);
			if (rowaffected == 1) {
				ResultSet resultSet = preparedStmt.getGeneratedKeys();
				preparedStmt.getGeneratedKeys();
				if (resultSet.next())
					emp_id = resultSet.getInt(1);
				employee.setId(emp_id);
			}

			// con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {

			Statement stmt = con.createStatement();
			double deductions = employee.getSalary() * 0.2;
			double taxable_pay = employee.getSalary() - deductions;
			double tax = taxable_pay * 0.1;
			double net_pay = employee.getSalary() - tax;

			String query = " insert into payroll_details (emp_id, basic_pay,deductions , taxable_pay, tax, net_pay)"
					+ " values ( ?, ?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, emp_id);
			preparedStmt.setDouble(2, employee.getSalary());
			preparedStmt.setDouble(3, deductions);
			preparedStmt.setDouble(4, taxable_pay);
			preparedStmt.setDouble(5, tax);
			preparedStmt.setDouble(6, net_pay);

			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void getEmployee() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "ROOT");
			Statement stmt = con.createStatement();

			String query = "SELECT employee_payroll.emp_id,employee_payroll.name ,payroll_details.net_pay  FROM employee_payroll\r\n"
					+ "	INNER JOIN payroll_details ON employee_payroll.emp_id=payroll_details.emp_id; ";

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("emp_id");
				String Name = rs.getString("name");
				String Net_Pay = rs.getString("net_pay");

				System.out.format("%s ,%s ,%s", id, Name, Net_Pay);
				System.out.println();
			}
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.execute();

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}