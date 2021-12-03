package za.co.webtonic.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import za.co.webtonic.model.Student;
import za.co.webtonic.repository.StudentRepository;
import za.co.webtonic.util.fileReader;

@Service
public class StudentService {
	
	
	@Autowired
	private StudentRepository  repo;
	
	

	  public void save(MultipartFile file) {
	    try {
	    	
	   
	      List<Student> student = fileReader.csvToStudents(file.getInputStream());
	    
	      repo.saveAll(student);
	      
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }



	  public List<Student> getAllStudents() {
	    return repo.findAll();
	  }

}
