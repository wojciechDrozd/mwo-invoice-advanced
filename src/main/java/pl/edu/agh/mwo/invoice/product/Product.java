package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) throws IllegalArgumentException {
		

		if (name == null || name == "" || price == null || price.compareTo(new BigDecimal("0"))==-1) {
			throw new IllegalArgumentException();
		}
		else {
			this.name = name;
			this.price = price;
			this.taxPercent = tax;
		}

	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return (this.price.add(this.price.multiply(taxPercent)));
	}
}
