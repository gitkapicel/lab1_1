/*
 /*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem {

	private ProductInfo product;
	
	private int quantity;

	private Cost totalCost;

	private Discount discount;
	
	public OfferItem(ProductInfo product, int quantity){
		this(product, quantity, null, null);
	}

	public OfferItem(ProductInfo product, int quantity,
			Discount discount, String discountCause) {
		
		this.setProduct(product);
		this.quantity = quantity;
		this.discount = discount;

		Cost discountValue = new Cost(new BigDecimal(0));
		if (discount != null)
			discountValue = discountValue.subtract(discount.getMoney());

		this.totalCost = product.getProductPrice()
				.multiply(new Cost(new BigDecimal(quantity))).subtract(discountValue);
	}


	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((getProduct().getProductName() == null) ? 0 : getProduct().getProductName().hashCode());
		result = prime * result + ((getProduct().getProductPrice() == null) ? 0 : getProduct().getProductPrice().hashCode());
		result = prime * result
				+ ((getProduct().getProductId() == null) ? 0 : getProduct().getProductId().hashCode());
		result = prime * result + ((getProduct().getProductType() == null) ? 0 : getProduct().getProductType().hashCode());
		result = prime * result + quantity;
		result = prime * result
				+ ((totalCost == null) ? 0 : totalCost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferItem other = (OfferItem) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if(!getProduct().equals(other.getProduct()))
			return false;
		if (quantity != other.quantity)
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}

	/**
	 * 
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		
		if(!getProduct().equals(other.getProduct()))
			return false;

		if (quantity != other.quantity)
			return false;

		Cost max, min;
		if (totalCost.compareTo(other.totalCost) > 0) {
			max = totalCost;
			min = other.totalCost;
		} else {
			max = other.totalCost;
			min = totalCost;
		}

		Cost difference = max.subtract(min);
		Cost acceptableDelta = max.multiply(new Cost(new BigDecimal(delta / 100)));

		return acceptableDelta.compareTo(difference) > 0;
		}
		
		public ProductInfo getProduct() {
				return product;
			}
			
			public void setProduct(ProductInfo product) {
				this.product = product;
			}

}