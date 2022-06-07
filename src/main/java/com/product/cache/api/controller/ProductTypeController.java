package com.product.cache.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.cache.api.service.ProductTypeService;

@RestController
@RequestMapping(value = "product-type")
public class ProductTypeController {

	@Autowired
	ProductTypeService productTypeService;
	
	@GetMapping(value = "", produces = { "application/json" })
	public ResponseEntity<Object> getProductType() {

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
