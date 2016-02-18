package shop;

import java.util.HashMap;
import java.util.Map;

import shop.enums.OrderStatus;

public class Order {
	private Customer customer;
	private OrderStatus orderStatus;
	private Map<Product, Integer> goods = new HashMap<Product, Integer>();

	// constructors
	public Order(Customer customer, OrderStatus orderStatus, Map<Product, Integer> goods) {
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.goods = goods;
	}

	// getters/setters
	public Customer getCustomer() {
		return customer;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Map<Product, Integer> getGoods() {
		return goods;
	}
}
