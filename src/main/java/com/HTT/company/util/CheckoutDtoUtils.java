package com.HTT.company.util;

import java.util.Map;

import com.HTT.company.constant.ApplicationConstant;
import com.HTT.company.dto.CheckoutDto;

public class CheckoutDtoUtils {

	public static CheckoutDto MapStringStringparseToCheckoutDto(Map<String, String> checkOutMap) {
		
//		private String firstName;		
//		private String lastName;
//		private String country;
//		private String address;
//		private String townCity;
//		private String countryState;
//		private String postcodeZip;
//		private String phone;
//		private String email;
//		private String sendMail;		
//		private String payment;
//		private Map<Product, Integer> mapProduct;
//		private String coupon;
//		private Double subTotal;
//		private Double total;
		
		
		checkOutMap.get(checkOutMap);
		CheckoutDto checkoutDto = (CheckoutDto) ApplicationConstant.APPLICATION_CONTEXT.getBean("getCheckoutDto");
		checkoutDto.setFirstName(checkOutMap.get("firstName"));
		checkoutDto.setLastName(checkOutMap.get("lastName"));
		checkoutDto.setCountry(checkOutMap.get("country"));
		checkoutDto.setTownCity(checkOutMap.get("townCity"));
		checkoutDto.setCountryState(checkOutMap.get("countryState"));
		checkoutDto.setPostcodeZip(checkOutMap.get("postZip"));
		checkoutDto.setPhone(checkOutMap.get("phone"));
		checkoutDto.setEmail(checkOutMap.get("email"));
		checkoutDto.setSendMail(checkOutMap.get("sendMail"));
		checkoutDto.setPayment(checkOutMap.get("payment"));
		checkoutDto.setPostcodeZip(checkOutMap.get("postZip"));
		
		return null;
	}

}
