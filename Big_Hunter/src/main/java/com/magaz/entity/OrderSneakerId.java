package com.magaz.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderSneakerId implements Serializable {

	
	private static final long serialVersionUID = 4927688665536038752L;

	@ManyToOne
	private Orders order;
	
	@ManyToOne
	private Sneaker sneaker;

	public OrderSneakerId() {
		super();
	}

	public OrderSneakerId(Orders order) {
		super();
		this.order = order;
	}

	public OrderSneakerId(Sneaker sneaker) {
		super();
		this.sneaker = sneaker;
	}

	public OrderSneakerId(Orders order, Sneaker sneaker) {
		super();
		this.order = order;
		this.sneaker = sneaker;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Sneaker getSneaker() {
		return sneaker;
	}

	public void setSneaker(Sneaker sneaker) {
		this.sneaker = sneaker;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((sneaker == null) ? 0 : sneaker.hashCode());
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
		OrderSneakerId other = (OrderSneakerId) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (sneaker == null) {
			if (other.sneaker != null)
				return false;
		} else if (!sneaker.equals(other.sneaker))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
}
