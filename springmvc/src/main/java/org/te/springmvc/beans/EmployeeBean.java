package org.te.springmvc.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EmployeeInfo")
public class EmployeeBean implements Serializable {

	@Id
	@Column(name = "User_Id")
	private int id;

	@Column(name = "Username")
	private String name;

	@Column(name = "dob")
	private Date dateofbirth;

	private String Password;
}
