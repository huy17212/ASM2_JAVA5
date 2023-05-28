package com.HTT.company.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HTT.company.constant.FindArgsConstaint;
import com.HTT.company.entity.Finder;
import com.HTT.company.entity.Product;
import com.HTT.company.enumeration.Branding;
import com.HTT.company.enumeration.Categories;
import com.HTT.company.enumeration.Color;
import com.HTT.company.enumeration.FilterPrice;
import com.HTT.company.enumeration.Size;
import com.HTT.company.enumeration.SortingByPrice;
import com.HTT.company.enumeration.Tag;
import com.HTT.company.service.ProductService;
import com.google.gson.Gson;

@Controller
public class HomeController {

	@Autowired
	ProductService productService;

	// loading constaint in categories, branding, FILTER PRICE, size, color, tag.
	
	@ModelAttribute("categories")
	public List<Categories> getCategories() {
		return Arrays.asList(Categories.values());
	}

	@ModelAttribute("branding")
	public List<Branding> getBranding() {
		return Arrays.asList(Branding.values());
	}

	@ModelAttribute("filterPrice")
	public List<FilterPrice> getFilterPrice() {
		return Arrays.asList(FilterPrice.values());
	}

	@ModelAttribute("size")
	public List<Size> getSize() {
		return Arrays.asList(Size.values());
	}

	@ModelAttribute("color")
	public List<Color> getColor() {
		return Arrays.asList(Color.values());
	}

	@ModelAttribute("sortingByPrice")
	public List<SortingByPrice> getSortingByPrice() {
		return Arrays.asList(SortingByPrice.values());
	}

	@ModelAttribute("tag")
	public List<Tag> getTag() {
		return Arrays.asList(Tag.values());
	}
	
	@GetMapping("/showAllProduct")
	public String HomeController1(Model model,
			@RequestParam(defaultValue = "5", name = "pageNumber") Integer pageNumber) {	
		model.addAttribute("list_product", productService.loadProductByConstaint());
		return "views/another_view/shop";
	}
	
	@ResponseBody
	@PostMapping("FindArgsConstaint")
	public ResponseEntity<?> FindArgsConstaint( @RequestBody String find, Model model){
		
		Finder dinder = new Gson().fromJson(find, Finder.class);
		
		// 1 = categories_code
		// 2 = brand_code
//		productService.parseStringToFindArgsConstant(find); productService.loadProductByConstaint()
		System.out.println("kaka " + dinder.toString());
		
		return ResponseEntity.ok(find);
	}

}
