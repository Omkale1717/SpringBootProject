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

import com.sit.DTOEmployee.EmployeeDTO;
import com.sit.ServiesEmployeeIMPL.ServiesIMPL;
import com.sit.model.Employee;

import jakarta.validation.Valid;

@RestController

@RequestMapping("/EmployeeInfo")

public class ControllerEmployee {
	
	
	
	@Autowired
	private ServiesIMPL seriviesimpl;
	
	@PostMapping("/insertData")
	public String insertData( @Valid  @RequestBody Employee employee) {
		
		seriviesimpl.insertData(employee);
		
		return "Data inserted Successfully..!!";
		
	}
	
	@GetMapping("/{id}")
	public Employee getSingleData( @Valid  @PathVariable long id) {
	return 	seriviesimpl.getSingleData(id);
		
	}
	@GetMapping("/getAllData")
	public List<EmployeeDTO> getAllData() {
		 List<EmployeeDTO> allData =(List<EmployeeDTO>)	seriviesimpl.getAllData();
		 
		 return allData;
		
		
	}
	
	@PutMapping("/updatingData/{id}")
	public String updateData( @Valid @PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		     
	String updtEmployee=	seriviesimpl.updateData(id, employee);
		
		return  updtEmployee;
			
	}
	@DeleteMapping("/deletedata/{id}")
	public String deleteData(  @Valid @PathVariable ("id") long id) {
		seriviesimpl.deleteData(id);
		return "Data Deleted SuccessFully "+id;
		
		
		
	}
	

}
