package com.sit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ClassStudent")
public class ClassStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_Id")
	private long id;

	@NotBlank(message = "Name is required")
	@Column(name = "Student_Name")
	private String name;

	@Email(message = "Invalid email format")
	@Column(name = "Student_Email")
	private String email;

	@NotBlank
	@Column(name = "Student_CurrentAddress")
	private String currentAddress;
	@NotBlank
	@Column(name = "Student_PermentAddress")
	private String permentAddress;
	
	@Column(name = "Student_Password")
	@NotBlank
	private String password;


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

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermentAddress() {
		return permentAddress;
	}

	public void setPermentAddress(String permentAddress) {
		this.permentAddress = permentAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ClassStudent [id=" + id + ", name=" + name + ", email=" + email + ", currentAddress=" + currentAddress
				+ ", permentAddress=" + permentAddress + ", password=" + password + "]";
	}

}
