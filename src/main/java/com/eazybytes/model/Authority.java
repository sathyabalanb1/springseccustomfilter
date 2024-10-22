package com.eazybytes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="authorities")
public class Authority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	/*
	With this @ManyToOne, what we are conveying to the Spring JPA framework is multiple authority
	records can be mapped, put to a single record
	of customer table.
	*/
	
	
	
	

}
