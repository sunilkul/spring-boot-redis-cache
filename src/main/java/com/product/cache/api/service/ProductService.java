package com.product.cache.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.product.cache.api.output.ProductInfo;

@Service
public class ProductService {

	/**
	 * Function returns products data without cache
	 * 
	 * @return
	 */
	public List<ProductInfo> getProductInfo() {

		System.out.println("Start of delay: " + new Date());
		// Delay for 4 seconds
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("End of delay: " + new Date());

		List<ProductInfo> productInfoList = new ArrayList<>();
		Random r = new Random();

		for (int i = 0; i <= 10; i++) {
			ProductInfo p = new ProductInfo();
			p.setProductId(i);
			p.setProductName("Test Product " + i);
			p.setPrice(i * 100.00);
			p.setProductTypeId(r.nextInt((3 - 1) + 1) + 1);
			productInfoList.add(p);

		}

		return productInfoList;

	}

	/**
	 * Function executes block at once only after that it returns from cache
	 * 
	 * @return
	 */

	@Cacheable(value = "products")
	public List<ProductInfo> getProductCacheInfo() {

		System.out.println("Start of delay Product Cache : " + new Date());
		// Delay for 4 seconds
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("End of delay  Product Cache : " + new Date());

		List<ProductInfo> productInfoList = new ArrayList<>();

		Random r = new Random();

		for (int i = 0; i <= 10; i++) {
			ProductInfo p = new ProductInfo();
			p.setProductId(i);
			p.setProductName("Test Product " + i);
			p.setProductTypeId(r.nextInt((3 - 1) + 1) + 1);
			p.setPrice(i * 100.00);
			productInfoList.add(p);

		}

		return productInfoList;

	}

	/**
	 * Function is to cache data only if product id = 5
	 * 
	 * @param id
	 * @return
	 */
	@Cacheable(value = "productFilter", condition = "#id==5")
	public ProductInfo getProductCacheInfo(Integer id) {

		System.out.println("Start of delay Product Condition Cache : " + new Date());
		// Delay for 4 seconds
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("End of delay  Product Condition Cache : " + new Date());

		List<ProductInfo> productInfoList = new ArrayList<>();

		Random r = new Random();

		for (int i = 0; i <= 10; i++) {
			ProductInfo p = new ProductInfo();
			p.setProductId(i);
			p.setProductName("Test Product " + i);
			p.setProductTypeId(r.nextInt((3 - 1) + 1) + 1);
			p.setPrice(i * 100.00);
			productInfoList.add(p);

		}

		Optional<ProductInfo> pInfo = productInfoList.stream().filter(x -> x.getProductId() == id).findFirst();
		return pInfo.isPresent() ? pInfo.get() : null;

	}

	@Caching(evict = { @CacheEvict(value = "products", allEntries = true) })
	public String addProduct(ProductInfo productInfo) {

		return "Success";
	}

}
