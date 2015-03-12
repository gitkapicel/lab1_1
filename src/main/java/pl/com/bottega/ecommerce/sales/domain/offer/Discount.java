package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
	private String discountCause;

	private Cost cost;
	
	
	
	public Cost getMoney() {
		return cost;
	}

	public void setMoney(Cost cost) {
		this.cost = cost;
	}
	
	public boolean equals(Object obj) {
		Discount other = (Discount)obj;
		if(other.cost != cost)
			return false;
		if(other.discountCause != discountCause)
			return false;
		return true;
	}

}
