package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Cost {
	
	private String currency;
	
	private BigDecimal productPrice;
	
	public Cost(BigDecimal value){
		this.setproductPrice(value);
	}
	public boolean equals(Object obj) {
		Cost other = (Cost)obj;
		if(other.getproductPrice() != getproductPrice())
			return false;
		if(other.currency != currency)
			return false;
		return true;
	}
	public BigDecimal getproductPrice() {
		return productPrice;
	}
	public void setproductPrice(BigDecimal value) {
		this.productPrice = value;
	}
	public Cost subtract(Cost money) {
		return new Cost(productPrice.subtract(money.getproductPrice()));
	}
	public Cost multiply(Cost money) {
		return new Cost(productPrice.multiply(money.getproductPrice()));
	}
	
	public int compareTo(Cost totalCost) {
		return productPrice.compareTo(totalCost.productPrice);
	}
}
