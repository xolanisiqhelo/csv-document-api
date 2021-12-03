package za.co.webtonic;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import za.co.webtonic.service.StudentService;


@SpringBootTest
@AutoConfigureMockMvc
class CsvDocumentApiApplicationTests {
	
	@Autowired
	  MockMvc mockMvc;
	
	
	@Autowired
	private StudentService service;
	 

	 
//	  @Test
	  public void test_handleFileUpload() throws Exception {
	    String fileName = "data.csv";
	    MockMultipartFile data = new MockMultipartFile(
	      "file",
	      fileName, 
	      "text/csv",
	      "This is the file content".getBytes()
	    );
	 
	    MockMultipartHttpServletRequestBuilder multipartRequest =
	      MockMvcRequestBuilders.multipart("/api/upload");
	 
	    mockMvc.perform(multipartRequest.file(data))
	      .andExpect(status().isOk());
	 
	 
	  }
	  
	  
//	  @Test
	   public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
	      Mockito.when(service.getAllStudents());
	   }
	 
	  

}
