package com.ecommerce.cart.entity.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="t_categories")
public class Category {

	@Id
	@Column(name="c_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="c_name", nullable = false)
	private String name;
	
	@Column(name="c_description", nullable = false)
	private String description;
	
	/*
	@OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
	*/
	
	
}
