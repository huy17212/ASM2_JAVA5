package com.HTT.company.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.HTT.company.dto.CheckoutDto;
import com.HTT.company.entity.Product;
import com.HTT.company.service.ProductService;
import com.google.gson.Gson;

@Controller
public class CheckoutController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("checkOutCart")
	public String showCheckOut(@RequestParam(defaultValue = "0.0", name = "true_total") Double toltal, @RequestParam(defaultValue = "0.0", name = "true_subTotal") Double subTotal ,Model model, HttpServletRequest request, HttpServletResponse respone) {				
		// get all products in cookies
		Map<Product, Integer> mapProduct = new LinkedHashMap<>();
		Cookie[] cookies = request.getCookies();
		
		model.addAttribute("true_total", toltal);
		model.addAttribute("true_subTotal", subTotal);

		if (cookies != null) {
			for (Cookie item : cookies) {
				if (item.getName().contains("product")) {
					mapProduct.put(productService.findByProductId(item.getName()), Integer.parseInt(item.getValue()));
				}
			}
			model.addAttribute("mapProduct", mapProduct);
			return "views/another_view/checkout";
		}
		model.addAttribute("mapProduct", new ArrayList());
		return "views/another_view/checkout";
	}
	
	@PostMapping("checkOrder")
	public ResponseEntity<?> checkOrder(@RequestBody CheckoutDto data) {
//		
//		CheckoutDto billWillBePay = new Gson().fromJson(data, CheckoutDto.class);
//		
		System.out.print("Kaka Huy Tri " +data.toString());
		
		return ResponseEntity.ok(null);
	}

}
