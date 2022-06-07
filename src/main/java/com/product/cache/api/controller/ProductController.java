package com.product.cache.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.cache.api.output.ProductInfo;
import com.product.cache.api.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "", produces = { "application/json" })
	public ResponseEntity<List<ProductInfo>> getProductInfo() {

		return new ResponseEntity<>(productService.getProductInfo(), HttpStatus.OK);

	}

	@GetMapping(value = "/cache", produces = { "application/json" })
	public ResponseEntity<List<ProductInfo>> getProductCacheInfo() {

		return new ResponseEntity<>(productService.getProductCacheInfo(), HttpStatus.OK);

	}

	@GetMapping(value = "/cache/{id}", produces = { "application/json" })
	public ResponseEntity<ProductInfo> getProductCacheInfoById(@PathVariable(name = "id", required = true) Integer id) {

		return new ResponseEntity<>(productService.getProductCacheInfo(id), HttpStatus.OK);

	}
	
	
	@PostMapping(value = "", produces = { "application/json" })
	public ResponseEntity<String> saveProductInfo(@RequestBody ProductInfo productInfo) {

		return new ResponseEntity<>(productService.addProduct(productInfo), HttpStatus.OK);

	}


}
