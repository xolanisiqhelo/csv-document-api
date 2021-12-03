package za.co.webtonic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;


import za.co.webtonic.model.Student;


public class fileReader {
	
	 public static String TYPE = "text/csv";
	  static String[] HEADERs = {"Id","Student Number","Firstname", "Surname", "Course Code","Course Description","Grade" };

	  
	  
	  
	  public static boolean hasCSVFormat(MultipartFile file) {
	 System.out.println(file.getContentType());
	    if (TYPE.equals(file.getContentType())
	    		|| file.getContentType().equals("application/vnd.ms-excel")) {
	      return true;
	    }

	    return false;
	  }

	  public static List<Student> csvToStudents(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	       
	      List<Student> students = new ArrayList<>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      System.out.println("data------>"+csvRecords);
	      for (CSVRecord csvRecord : csvRecords) {
	    	  Student student = new Student(
	    			  
	    		  csvRecord.get(1),
	              csvRecord.get("Student Number"),
	              csvRecord.get("Firstname"),
	              csvRecord.get("Surname"),
	              csvRecord.get("Course Code"),
	              csvRecord.get("Course Description"),
	              csvRecord.get("Grade")
	            );
	    	  
	    	  System.out.println("data------>"+student);
		    	
	    	  students.add(student);
	    	  
	    	  
	      }

	      return students;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }



}
