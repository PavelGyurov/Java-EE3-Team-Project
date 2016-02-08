package shop;

import java.util.Date;

import shop.enums.PaymentStatus;
import shop.enums.PaymentType;

public class Payment {
	private Date paymentDate;
	private PaymentType paymentType;
	private PaymentStatus paymentStatus;
	private Order order;
	
	private Date paymentFulfilled;
	private Date paymentConfirmed;

	// constructors
	public Payment(Date paymentDate, PaymentType paymentType, PaymentStatus paymentStatus, Order order) {
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.order = order;
	}

	// getters/setters
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getPaymentFulfilled() {
		return paymentFulfilled;
	}

	public void setPaymentFulfilled(Date paymentFulfilled) {
		this.paymentFulfilled = paymentFulfilled;
	}

	public Date getPaymentConfirmed() {
		return paymentConfirmed;
	}

	public void setPaymentConfirmed(Date paymentConfirmed) {
		this.paymentConfirmed = paymentConfirmed;
	}

}
