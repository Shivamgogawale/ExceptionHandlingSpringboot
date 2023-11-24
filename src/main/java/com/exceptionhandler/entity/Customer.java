package com.exceptionhandler.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
	public class Customer {
	
		@Id
		@GeneratedValue
		private int id;
		
		private String name;
		
		private String address;
		
		private int age;
		
		private String contactNumber;
	}
