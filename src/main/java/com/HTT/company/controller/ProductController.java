package com.HTT.company.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HTT.company.constant.ListConstaint;
import com.HTT.company.entity.Product;
import com.HTT.company.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("showInfomation")
	public String getDetailProduct(@RequestParam("productId") String productId, Model model) {

		Product product = productService.findByProductId(productId);
		model.addAttribute("productDetail", product);
		return "views/another_view/shop-details";
	}

	
	// add to cart and return showAllProduct.
	@GetMapping("/addToCart1")
	public String addToCard(@RequestParam(name = "productId") String productId, HttpSession session) {
		ListConstaint.USER_CART.add(productId);
		return "redirect:/showAllProduct";
	}
	
	
	@GetMapping("/addToCart2")
	public String addToCard2(@RequestParam(name = "productId") String productId, HttpSession session) {
		ListConstaint.USER_CART.add(productId);
		return "redirect:/shop-details?productId=" + productId;
	}
	
	@GetMapping("/showCart")
	public String viewCard() {
		
		Set<String> distinct = new LinkedHashSet<>(ListConstaint.USER_CART);
		
		Map<Product, Integer> mapProduct = new LinkedHashMap<>();
		
		distinct.forEach(item -> {
				mapProduct.put(productService.findByProductId(item), Collections.frequency(ListConstaint.USER_CART, item));
		});
		
		return "views/another_view/shopping-cart";
	}
}
