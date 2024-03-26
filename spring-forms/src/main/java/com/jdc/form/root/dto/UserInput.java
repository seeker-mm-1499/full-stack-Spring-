package com.jdc.form.root.dto;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.jdc.form.mvc.validator.Phone;

import lombok.Data;

@Data
public class UserInput {
	
	private int id;
	@NotBlank(message = "{empty.employee.name}")
	private String name;
	@Phone(message = "Please enter phone no",pattern = "09\\d-\\d{3}-\\d{3}")
	private String phone;
	@Email(message = "Invalid email address")
	private String email;
	private String password;
	@NotNull(message = "Please select course")
	private Course course;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registration;
	private Gender gender;
	private String[] foundations;
	@AssertTrue(message = "You have to agree")
	private Boolean agree;
	private String remark;
	
	public enum Gender{
		Male, Female
	}
}
