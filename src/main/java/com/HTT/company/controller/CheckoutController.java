package com.HTT.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

	@GetMapping("checkOutCart")
	public String showCheckOut() {
		return "views/another_view/checkout";
	}

}
