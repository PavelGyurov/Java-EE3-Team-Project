package shop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private static final String ERR_NO_SUCH_PRODUCT = "No such product in shopping cart: %s";

	private Customer customer;
	private Map<Product, Integer> goods = new HashMap<Product, Integer>();

	// constructors
	public ShoppingCart(Customer customer) {
		this.customer = customer;
	}

	// getters/setters
	public Customer getCustomer() {
		return customer;
	}

//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Map<Product, Integer> getGoods() {
		return goods;
	}

//	public void setGoods(Map<Product, Integer> goods) {
//		this.goods = goods;
//	}

	// behavior
	public void addProduct(Product product) {
		if (goods.containsKey(product)) {
			Integer amount = goods.get(product);
			goods.put(product, amount + 1);
		} else {
			goods.put(product, Integer.valueOf(1));
		}
	}

	public void removeProduct(Product product) {
		if (goods.containsKey(product)) {
			goods.remove(product);
		} else {
			throw new IllegalArgumentException(String.format(
					ERR_NO_SUCH_PRODUCT, product.getName()));
		}
	}

	public double incrementProductQuantity(Product product) {
		return changeProductQuantity(product, true);
	}

	public double decrementProductQuantity(Product product) {
		return changeProductQuantity(product, false);
	}
	
	private double changeProductQuantity(Product product, boolean operation) {
		if(goods.containsKey(product)) {
			Integer amount = goods.get(product) + (operation ? 1 : -1);
			goods.put(product, amount);
			return amount;
		} else {
			throw new IllegalArgumentException(String.format(
					ERR_NO_SUCH_PRODUCT, product.getName()));
		}
	}

	public void removeAllProducts() {
		goods.clear();
	}

}
