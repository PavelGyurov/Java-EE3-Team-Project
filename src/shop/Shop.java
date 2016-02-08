package shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shop.enums.CustomerOnlineStatus;

public class Shop {
	private String name;
	private String description;

	// all customers by their usernames
	private Map<String, Customer> customers = new HashMap<String, Customer>();

	// all customers by their online status
	private Map<Customer, CustomerOnlineStatus> customersStatuses = new HashMap<Customer, CustomerOnlineStatus>();

	// constructors

	// getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public boolean isUsernameUnique(String probeUsername) {
		return !customers.containsKey(probeUsername);
	}

	public Customer registerCustomer(String username, String password, String fullname, List<Address> addresses) {
		Customer customer = null;
		if (isUsernameUnique(username)) {
			customer = new Customer(username, password, fullname, addresses);
			customers.put(username, customer);
			customersStatuses.put(customer, CustomerOnlineStatus.OFFLINE);
			return customer;
		} else {
			throw new IllegalArgumentException(String.format(
					"Given username %s is already used! Please try with some other username.", username));
		}
	}

	public void doCustomerLogin(Customer customer) {
		customer.setStatus(CustomerOnlineStatus.ONLINE);
		customersStatuses.put(customer, CustomerOnlineStatus.ONLINE);
	}
	
	public void doCustomerLogout(Customer customer) {
		customer.setStatus(CustomerOnlineStatus.OFFLINE);
		customersStatuses.put(customer, CustomerOnlineStatus.OFFLINE);
	}
}
