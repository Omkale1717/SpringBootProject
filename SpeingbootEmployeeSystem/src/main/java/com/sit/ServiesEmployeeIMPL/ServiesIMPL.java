package com.sit.ServiesEmployeeIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.DTOEmployee.EmployeeDTO;
import com.sit.ExceptionHandler.UserNotFoundException;
import com.sit.RepositoryEmployee.RepositoryEmployee;
import com.sit.Serives.ServiesI;
import com.sit.model.Employee;

@Service

public class ServiesIMPL implements ServiesI {

	@Autowired
	private RepositoryEmployee repositoryEmp;

	@Override
	public Employee insertData(Employee employee) {

		return repositoryEmp.save(employee);
	}

	@Override
	public Employee getSingleData(long id) {
		return repositoryEmp.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Thies type DatainAvilable plz put valid Data..!!" + id));
	}

	public List<EmployeeDTO> getAllData() {
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		List<Employee> employees = repositoryEmp.findAll();

		for (Employee employee : employees) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setId(employee.getId());
			dto.setName(employee.getName());
			dto.setEmail(employee.getEmail());
			employeeDTOs.add(dto);
		}

		return employeeDTOs; // Correct return statement
	}

	@Override
	public String updateData( Long id,  Employee employee) {
	  Employee exsitingemp=  	repositoryEmp.findById(id)
			  .orElseThrow(()->new UserNotFoundException("Could not find student with ID: " + id));
	  exsitingemp.setName(employee.getName());
	  exsitingemp.setEmail(employee.getEmail());
	  exsitingemp.setAddr(employee.getAddr());
	  exsitingemp.setBanknum(employee.getBanknum());
	  
	  
	  
	return   "Your data Update SuccessFull..!!"+ repositoryEmp.save(exsitingemp) ;
	 	
		
	}

	@Override
	public void deleteData(long id) {
		  Employee exsitingemp= 	repositoryEmp.findById(id)
				  .orElseThrow(()-> new  UserNotFoundException("Could not find student with ID: "+id));
		  repositoryEmp.deleteById(id);
		  
		
		
	}

}
