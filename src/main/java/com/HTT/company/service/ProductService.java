package com.HTT.company.service;

import java.util.List;

import com.HTT.company.entity.Product;

public interface ProductService {
	
	List<Product> getAllProduct();
	
	Product findByProductId(String productId);
	
	List<Product> loadProductByConstaint();
	
	void parseStringToFindArgsConstant(String listCode);
	
}
