package com.product.cache.api.output;

import java.io.Serializable;

public class ProductInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 89462461648558230L;
	private Integer productId;
	private String productName;
	private Double price;
	private Integer productTypeId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public ProductInfo() {
	}

	public ProductInfo(Integer productId, String productName, Double price, Integer productTypeId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productTypeId = productTypeId;
	}

	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", productTypeId=" + productTypeId + "]";
	}

}
