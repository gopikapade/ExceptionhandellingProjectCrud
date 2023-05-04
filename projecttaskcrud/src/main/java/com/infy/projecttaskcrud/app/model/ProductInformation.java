package com.infy.projecttaskcrud.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int infoid;
	private String brand, model, specification;

}
