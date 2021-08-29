package com.address.book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class AddressBookOpenCSV {
	private static String HOME = System.getProperty("src\\main\\resources\\abc.csv");
	private static String fileName = "abc.csv";
	private static Path homePath = Paths.get(HOME);

	public static boolean readCSV() throws IOException, Exception {
		if (Files.exists(homePath)) {
			Path filePath = Paths.get(HOME + "/" + fileName);
			if (Files.exists(filePath)) {
				CSVReader csvreader = new CSVReader(new FileReader(String.valueOf(filePath)));
				String[] line = csvreader.readNext();
				while (line != null) {
					System.out.println(line);
					line = csvreader.readNext();
				}
				csvreader.close();
			}
		}
		return true;
	}

	public static boolean writeCSVFile(ArrayList<String[]> addContact) throws IOException {
		if (Files.exists(homePath)) {
			Path filePath = Paths.get(HOME + "/" + fileName);
			try {
				if (Files.exists(filePath)) {
					CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
					for (String[] contact : addContact) {
						writer.writeNext(contact);
					}
					writer.flush();
					return true;
				} else {
					Files.createFile(filePath);
					CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
					for (String[] contact : addContact) {
						writer.writeNext(contact);
					}
					writer.flush();
					return true;
				}
			} catch (IOException e) {
				return false;
			}
		} else
			return false;

	}
}