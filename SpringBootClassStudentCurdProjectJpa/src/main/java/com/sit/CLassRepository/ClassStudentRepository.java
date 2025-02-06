package com.sit.CLassRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sit.model.ClassStudent;

@Repository
public interface ClassStudentRepository extends JpaRepository<ClassStudent, Long> {

}
