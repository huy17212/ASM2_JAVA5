package com.HTT.company.service.Impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HTT.company.constant.FindArgsConstaint;
import com.HTT.company.entity.Product;
import com.HTT.company.repository.ProductRepository;
import com.HTT.company.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAllUsers();
	}

	@Override
	public Product findByProductId(String productId) {
		return productRepository.findByProductId(productId);
	}

	@Override
	public List<Product> loadProductByConstaint() {

		List<Product> listProduct = getAllProduct();
		
		listProduct = listProduct.stream()
				.filter(item -> item.getProductCategory().contains(FindArgsConstaint.CATEGORIES_CODE)
						&& item.getProductBrand().contains(FindArgsConstaint.BRANDING_CODE)
						&& (item.getProductPrice() >= FindArgsConstaint.START)
						&& (item.getProductPrice() <= FindArgsConstaint.END)
						&& item.getProductSize().contains(FindArgsConstaint.SIZE_CODE)
						&& item.getProductColor().contains(FindArgsConstaint.COLOR_CODE)
						&& item.getProducTag().contains(FindArgsConstaint.TAG_CODE))
				.toList();

//		Collections.sort(listProduct, (o1, o2) -> {
//			return Double.compare(o1.getProductPrice(), 0);
//		});
//
//		if (FindArgsConstaint.SORT_BY) {
//			Collections.reverse(listProduct);
//		}
		return listProduct;
	}

	@Override
	public void parseStringToFindArgsConstant(String listCode) {
		String code = listCode.split(",")[0];

		String thing = listCode.split(",")[1];

		switch (code) {
			case "1": {
				FindArgsConstaint.CATEGORIES_CODE = thing;
				break;
			}
			case "2":{
				FindArgsConstaint.BRANDING_CODE = thing.toLowerCase();
				break;
			}
			case "3":{
				FindArgsConstaint.SIZE_CODE = thing;
				break;
			}
			case "4":{
				FindArgsConstaint.COLOR_CODE = thing.toLowerCase();
				break;
			}	
		}
	}

}
