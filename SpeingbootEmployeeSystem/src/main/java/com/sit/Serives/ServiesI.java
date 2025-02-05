package com.sit.Serives;

import java.util.List;

import com.sit.DTOEmployee.EmployeeDTO;
import com.sit.model.Employee;

public interface ServiesI {
	
	public Employee insertData(Employee employee);
	
	public Employee getSingleData(long id);
	
	
	public List<EmployeeDTO> getAllData();
	
	public String updateData( Long id,   Employee employee);
	
	
	public void deleteData(long id );

}
