package com.opencsvproject.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVWriter;


@RestController
@RequestMapping(value="/opencsv")
public class CsvController {

	List<String[]> list = new ArrayList<>();
	public void createData() {
		String[] header = {"id","name","author"};
		list.add(header);
		list.add(new String[]{"1","Chaya","Prakasani"});
		list.add(new String[]{"2","Chaya","Prakasani"});
		list.add(new String[]{"3","Chaya","Prakasani"});
	
	}
	
	@GetMapping(value="/writecsv")
	public void write() throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter("e:\\opencsv\\file1.csv"));
		createData();
		writer.writeAll(list);
	}
	
}
