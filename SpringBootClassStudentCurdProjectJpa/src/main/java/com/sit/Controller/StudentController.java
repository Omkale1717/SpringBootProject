package com.sit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.ClassSericesIMPL.ClassServiesImpl;
import com.sit.model.ClassStudent;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	
	  @Autowired
	private ClassServiesImpl classServiesImpl;
	  
	  
	     @PostMapping("/InsertData")
		public String insertData( @Valid @RequestBody ClassStudent classStudent) {
	    	 
	    	 classServiesImpl.insertData(classStudent);
	    	  return "Data Successfull Inserted ..!!";
	    	 
	    	 
	   }
	     @GetMapping("/getallData")
	 	public List<ClassStudent> fetchData() {
	 		List<ClassStudent> fetchData =	classServiesImpl.fetchData();
	 		return fetchData;
	 		
	 	}
	     @PutMapping("/updatedta/{id}")
	 	public ClassStudent UpdateData(@Valid @PathVariable long id, @RequestBody ClassStudent classStudent) {
	    	 classStudent.setId(id);
	 		
	 		ClassStudent updateData =	classServiesImpl.UpdateData(id, classStudent);
	 		
	 		return updateData;
	 		
	 		
	 	}
	     @DeleteMapping("/deletedata/{id}")
	     public String deleteData( @PathVariable("id") long id) {
	    	 classServiesImpl.deleteData(id);
	    	 return "Delete data Successfull"+id;
	    	 
	    	 
	     }
	  
	  
	  
	  
	
	
	
	
	
	

}
