package com.ecommerce.cart.dto.response;

import java.util.List;

import com.ecommerce.cart.entity.jpa.Product;

public record CategoryDTOResponse(
		Long id_cat,
		String name,
		List<Product> product
	) {} 