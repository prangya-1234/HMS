package com.hms.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student_registration")
public class StudentRegistration {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String age;
	@Column
	private String dob;
	@Column
	private String phoneNo;
	@Column
	private String nationality;
	@Column
	private String emailId;
	@Column
	private String gender;
	@Column
	private String address;

}
