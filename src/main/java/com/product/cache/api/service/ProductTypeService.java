package com.product.cache.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.product.cache.api.output.ProductType;


@Service
public class ProductTypeService {

	@Cacheable(value = "productType")
	public List<ProductType> getProductTypeCacheInfo() {

		System.out.println("Start of delay Product Type Cache : " + new Date());
		// Delay for 4 seconds
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("End of delay  Product Type Cache : " + new Date());

		List<ProductType> productTypeList = new ArrayList<>();

		for (int i = 1; i <= 3; i++) {
			ProductType p = new ProductType();
			p.setId(i);
			p.setProductTypeName("ABC " + i);

			productTypeList.add(p);

		}

		return productTypeList;

	}

}
