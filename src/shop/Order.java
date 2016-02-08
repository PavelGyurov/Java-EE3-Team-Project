package shop;

import java.util.HashMap;
import java.util.Map;

import shop.enums.OrderStatus;

public class Order {
	private Customer customer;
	private OrderStatus orderStatus;
	private Map<Product, Double> goods = new HashMap<Product, Double>();

	// constructors
	public Order(Customer customer, OrderStatus orderStatus, Map<Product, Double> goods) {
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.goods = goods;
	}

	// getters/setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Map<Product, Double> getGoods() {
		return goods;
	}

	public void setGoods(Map<Product, Double> goods) {
		this.goods = goods;
	}

}
