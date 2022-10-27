package com.bridgelabz.EmployeePay;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileIOEmployee {

	void fileWriteWithFileWriter(String fileURL, String dataToWrite) throws IOException {
		FileWriter fileWriterObj = new FileWriter(fileURL, true);

		fileWriterObj.write(dataToWrite);

		fileWriterObj.close();

	}

	public static void readWriteOperation(List<Employee> empList)
			throws IOException, org.json.simple.parser.ParseException {

		FileIOEmployee fileWriterObj = new FileIOEmployee();

		String fileURL = "C:\\Users\\aashi\\eclipse-workspace\\EmployeePay\\src\\main\\resources\\EmployeePay.txt";
		// Converts Hashmap to JSON As ObjectMapper is used, it writes JSON // string
		ObjectMapper mapper = new ObjectMapper();

		try {

			String EmployeeJson = mapper.writeValueAsString(empList);

			// Print JSON output
			System.out.println("JSON" + EmployeeJson);
			fileWriterObj.fileWriteWithFileWriter(fileURL, EmployeeJson);
		}

		// Catching generic input output exceptions
		catch (IOException e) {
			e.printStackTrace();

		}
		try {
			FileIOEmployee.readJSONdata(fileURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readJSONdata(String fileURL)
			throws IOException, ParseException, org.json.simple.parser.ParseException {
		// 1 .FileReader Obj
		FileReader fileReaderObj = new FileReader(fileURL);
		// 2. creation of parser object
		JSONParser jsonParserObj = new JSONParser();
		// 3 . parsing filereader object using json parser and output is object passes
		// to
		// objRef of type Object
		Object objRef = jsonParserObj.parse(fileReaderObj);
		// 4creating refrence of array of json
		JSONArray employeeArrayObj = new JSONArray();
		employeeArrayObj.add(objRef);

		try {
			JSONObject jsonObject = (JSONObject) objRef;
			for (Object o : employeeArrayObj) {
				String id = (String) jsonObject.get("id");
				String name = (String) jsonObject.get("name");
				String gender = (String) jsonObject.get("gender");
				String salary = (String) jsonObject.get("salary");
				System.out.println("Emp_Id:::: " + id);
				System.out.println("Name: " + name);
				System.out.println("Gender:" + gender);
				System.out.println("Salary:" + salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
