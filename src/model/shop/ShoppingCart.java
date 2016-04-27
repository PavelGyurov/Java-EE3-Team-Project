package model.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
	private static final String ERR_NO_SUCH_PRODUCT = "No such product in shopping cart: %s";

	private Customer customer;
	private Map<Product, Integer> products;

	// constructors
	public ShoppingCart(Customer customer) {
		products = new HashMap<Product, Integer>();
		this.customer = customer;
	}

	// getters/setters
	public Customer getCustomer() {
		return customer;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	// behaviour
	public void addProduct(Product product) {
		if (products.containsKey(product)) {
			Integer amount = products.get(product);
			products.put(product, amount + 1);
		} else {
			products.put(product, Integer.valueOf(1));
		}
	}

	public void removeProduct(Product product) {
		if (products.containsKey(product)) {
			products.remove(product);
		} else {
			throw new IllegalArgumentException(String.format(
					ERR_NO_SUCH_PRODUCT, product.getModel()));
		}
	}

	public double incrementProductQuantity(Product product) {
		return changeProductQuantity(product, true);
	}

	public double decrementProductQuantity(Product product) {
		return changeProductQuantity(product, false);
	}
	
	private double changeProductQuantity(Product product, boolean operation) {
		if(products.containsKey(product)) {
			Integer amount = products.get(product) + (operation ? 1 : -1);
			products.put(product, amount);
			return amount;
		} else {
			throw new IllegalArgumentException(String.format(
					ERR_NO_SUCH_PRODUCT, product.getModel()));
		}
	}

	public void removeAllProducts() {
		products.clear();
	}

	public double getPriceForAll(){
		double price = 0;
		for(Entry<Product, Integer>  e: products.entrySet()){
			price += (e.getValue()*e.getKey().getPrice());
		}
		return price;
	}
}
