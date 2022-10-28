package com.bridgelabz.EmployeePay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileIOEmployee {

	public static void readJSONdata() throws IOException, ParseException {

		// public static void main(String[] args) throws IOException, ParseException {
		String fileURL = "C:\\Users\\aashi\\eclipse-workspace\\EmployeePay\\src\\main\\resources\\EmployeePay.txt";

		  String line = null;
	        try
	        {
	            FileReader fileReader = new FileReader(fileURL);
	            
	            // always wrap the FileReader in BufferedReader
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            
	            while((line = bufferedReader.readLine()) != null)
	            {
	                System.out.println(line);
	            }
	            
	            // always close the file after its use
	            bufferedReader.close();
	        }
	        catch(IOException ex)
	        {
	            System.out.println("\nError occurred");
	            System.out.println("Exception Name: " +ex);
	            ex.printStackTrace();
	        }
		
	}

	public static void fileWriteOperation(Employee employee) throws IOException, org.json.simple.parser.ParseException {

		String fileURL = "C:\\Users\\aashi\\eclipse-workspace\\EmployeePay\\src\\main\\resources\\EmployeePay.txt";
		// Converts Hashmap to JSON As ObjectMapper is used, it writes JSON // string
		ObjectMapper mapper = new ObjectMapper();

		try {

			FileWriter fileWriterObj = new FileWriter(fileURL, true);

			String EmployeeJson = mapper.writeValueAsString(employee);

			fileWriterObj.write("\n" + EmployeeJson);

			fileWriterObj.close();
		}

		// Catching generic input output exceptions
		catch (IOException e) {
			e.printStackTrace();

		}

	}

}
