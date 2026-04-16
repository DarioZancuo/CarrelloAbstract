package com.ecommerce.cart.dto.request;

import java.util.List;

import com.ecommerce.cart.entity.jpa.Product;

public record CategoryDTORequest(
		Long id_cat,
		String name,
		List<Product> product
	) {} 