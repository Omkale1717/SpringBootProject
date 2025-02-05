package com.sit.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="EmployeeSystem")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_Id")
	private long id;
	
	@Column(name = "Employee_Name")
	 @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2-50 characters")
 
	private String name ;
	
	@Column(name = "Employee_Email")
	  @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
	private String email;
	
	
	@Column(name = "Employee_BankDetilas")
	@NotBlank(message = "BankDetials is mandatory")
	private String banknum;
	
	@Column(name = "Employee_Address")
	
	@NotBlank(message = "Address Fild is Mandatory")
	@NonNull
	private String addr ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBanknum() {
		return banknum;
	}

	public void setBanknum(String banknum) {
		this.banknum = banknum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	
	

}
