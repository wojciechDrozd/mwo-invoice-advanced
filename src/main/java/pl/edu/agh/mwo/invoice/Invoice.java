package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

	private BigDecimal subtotal;
	private BigDecimal tax;
	private BigDecimal total;
	private HashMap<Product, Integer> productList = new HashMap<Product, Integer>();

	public void addProduct(Product product) {
		// TODO: implement
		productList.put(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
		productList.put(product, quantity);
	}

	public BigDecimal getSubtotal() {
		subtotal = new BigDecimal(0);
		Iterator<Entry<Product, Integer>> iter = productList.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Product, Integer> entry = iter.next();
			subtotal = subtotal
					.add((new BigDecimal(entry.getValue()))
							.multiply(entry.getKey().getPrice()));
		}
		return subtotal;
	}

	public BigDecimal getTax() {
		tax = total.subtract(subtotal);
		return null;
	}

	public BigDecimal getTotal() {
		total = new BigDecimal(0);
		Iterator<Entry<Product, Integer>> iter = productList.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Product, Integer> entry = iter.next();
			total = total
					.add((new BigDecimal(entry.getValue()))
							.multiply((entry.getKey().getPrice()).add(entry.getKey().getTaxPercent()).multiply(entry.getKey().getPrice())));
			
		}
		return total;
	}
}
