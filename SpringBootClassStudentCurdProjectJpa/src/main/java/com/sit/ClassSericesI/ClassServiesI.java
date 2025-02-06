package com.sit.ClassSericesI;

import java.util.List;

import com.sit.model.ClassStudent;

public interface ClassServiesI {
	
	public ClassStudent insertData(ClassStudent classStudent);
	
	public List<ClassStudent> fetchData();
	
	public ClassStudent UpdateData(long id,ClassStudent classStudent);
	
	public void deleteData(long id);

}
