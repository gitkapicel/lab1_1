package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class ProductInfo {
	// product
	private String productId;

	private Cost productPrice;

	private String productName;

	private Date productInfoDate;

	private String productType;
	


	public ProductInfo(String productId, Cost productPrice,
			String productName, Date productInfoDate, String productType) {
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.productInfoDate = productInfoDate;
		this.productType = productType;
	}

	public String getProductId() {
		return productId;
	}

	public Cost getProductPrice() {
		return productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public Date getProductInfoDate() {
		return productInfoDate;
	}

	public String getProductType() {
		return productType;
	}

	@Override
	public boolean equals(Object obj) {
		ProductInfo other = (ProductInfo) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productType != other.productType)
			return false;
		return true;
	}

}
