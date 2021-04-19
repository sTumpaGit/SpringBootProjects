package com.csvTry.jpa.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csvTry.jpa.model.Employee;
import com.opencsv.CSVWriter;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@RestController
@RequestMapping(value = "/csv")
public class Controller {
	
	
	
	public List<Employee> createData() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Tumpa Sheet","Kolkata"));
		list.add(new Employee(2, "Riya Das", "Uttarpara"));
		
		return list;
	}
	
	
	@GetMapping(value="/download/employee.csv")
	public void downloadfile(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=employee.csv");
		List<Employee> emp = createData();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
		
		String[] header = { "Name", "City"};
 
		csvWriter.writeHeader(header);
		 
        for (Employee emp1 : emp) {
            csvWriter.write(emp1, header);
        }
 
        csvWriter.close();
	}
	
}
