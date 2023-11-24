package com.exceptionhandler.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CustomerRequest {

	@NotBlank
	private String name;

	@NotEmpty
	private String address;

	@Max(value = 80,message = "Maximum age should be 80")
	@Min(value = 16,message = "Minimum age should be 16")
	private int age;

	@Pattern(regexp = "^[789]\\d{9}$")
	private String contactNumber;
}
