package com.magaz.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderSneaker {
	
	
	@EmbeddedId
	private OrderSneakerId id;
	
	
	private int quantityForBuy;


	public OrderSneaker() {
		super();
	}


	public OrderSneaker(OrderSneakerId id, int quantityForBuy) {
		super();
		this.id = id;
		this.quantityForBuy = quantityForBuy;
	}
	
	public OrderSneaker(Sneaker sneaker,int quantityForBuy){
		
		this.id = new OrderSneakerId(sneaker);
		this.quantityForBuy = quantityForBuy;
	}


	public OrderSneakerId getId() {
		return id;
	}


	public void setId(OrderSneakerId id) {
		this.id = id;
	}


	public int getQuantityForBuy() {
		return quantityForBuy;
	}


	public void setQuantityForBuy(int quantityForBuy) {
		this.quantityForBuy = quantityForBuy;
	}
	
	public Sneaker getSneaker(){
		return id.getSneaker();
	}
	public Orders getOrder(){
		return id.getOrder();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantityForBuy;
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
		OrderSneaker other = (OrderSneaker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantityForBuy != other.quantityForBuy)
			return false;
		return true;
	}
	
	
	
	
	

}
