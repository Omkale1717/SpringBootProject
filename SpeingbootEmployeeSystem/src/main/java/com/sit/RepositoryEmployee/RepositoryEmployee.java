package com.sit.RepositoryEmployee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sit.model.Employee;
@Repository

public interface RepositoryEmployee extends JpaRepository<Employee, Long> {

}
