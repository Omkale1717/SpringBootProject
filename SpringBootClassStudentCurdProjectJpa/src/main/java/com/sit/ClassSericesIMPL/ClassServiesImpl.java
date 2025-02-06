package com.sit.ClassSericesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.CLassRepository.ClassStudentRepository;
import com.sit.ClassSericesI.ClassServiesI;
import com.sit.ExceptionHandler.InvalidPasswordException;
import com.sit.ExceptionHandler.UserNotFoundException;
import com.sit.model.ClassStudent;

@Service
public class ClassServiesImpl implements ClassServiesI {

	@Autowired
	private ClassStudentRepository classStudentRepository;

	@Override
	public ClassStudent insertData(ClassStudent classStudent) {

		if (!isPasswordValid(classStudent.getPassword())) {

			throw new InvalidPasswordException(
					"Password Must contian at Least one latter,onenumber,and one special character");

		}
		return classStudentRepository.save(classStudent);
	}

	@Override
	public List<ClassStudent> fetchData() {
		List<ClassStudent> all = (List<ClassStudent>) classStudentRepository.findAll();

		return all;

	}

	@Override
	public ClassStudent UpdateData(long id, ClassStudent classStudent) {
		ClassStudent exstingStudent = classStudentRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Student not Found With Id :" + id));
		exstingStudent.setName(classStudent.getName());
		exstingStudent.setEmail(classStudent.getEmail());
		exstingStudent.setCurrentAddress(classStudent.getCurrentAddress());
		exstingStudent.setPermentAddress(classStudent.getPermentAddress());

		return classStudentRepository.save(exstingStudent);
	}

	// Custom password validation logic
	private boolean isPasswordValid(String password) {
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		return password.matches(regex);
	}

	@Override
	public void deleteData(long id) {
	  ClassStudent classStudent=	classStudentRepository.findById(id)
			  .orElseThrow(()-> new UserNotFoundException("Student not found thies ID.Plz put valid Id:"+id));
	  classStudentRepository.deleteById(id);
	  
		
		
	
		
	}

}
