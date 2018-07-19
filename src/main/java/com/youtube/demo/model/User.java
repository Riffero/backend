package com.youtube.demo.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User extends ParentEntity{

	private static final long serialVersionUID = -7233502633761017565L;
	
	@Column(name = "fist_name", nullable = false, length = 255)
	private String firstName;
	
	@Column(name = "second_name", nullable = true, length = 255)
	private String secondName;
	
	@Column(name = "fist_surname", nullable = false, length = 255)
	private String firstSurname;
	
	@Column(name = "second_surname", nullable = true, length = 255)
	private String secondSurname;
	
	@Column(name = "phone", nullable = true, length = 255)
	private String phone;
	
	@Column(name = "address", nullable = false, length = 150)
	private String address;
	

}
