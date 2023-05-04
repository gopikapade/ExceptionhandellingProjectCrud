package com.infy.projecttaskcrud.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer productid;
	private String productname;
	private Double productprise;
	/*
	 * @OneToOne(cascade = CascadeType.ALL) private ProductInformation
	 * productinformatio;
	 */
	
}
