package com.magaz.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDateTime date;
	
	
	@OneToMany(mappedBy = "id.order")
	private List<OrderSneaker> orderSneakers = new ArrayList<>();

	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "sneaker_orders", joinColumns = @JoinColumn(name = "id_orders"), inverseJoinColumns = @JoinColumn(name = "id_sneaker"))
	private Set<Sneaker> sneakers = new HashSet<>();

	

	public Orders() {
		super();
	}

	

	public Orders(LocalDateTime date) {
		super();
		this.date = date;
	}

	public Orders(User user) {
		this.user = user;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Set<Sneaker> getSneakers() {
		return sneakers;
	}



	public void setSneakers(Set<Sneaker> sneakers) {
		this.sneakers = sneakers;
	}



	public List<OrderSneaker> getOrderSneakers() {
		return orderSneakers;
	}



	public void setOrderSneakers(List<OrderSneaker> orderSneakers) {
		this.orderSneakers = orderSneakers;
	}
	
	
	





	
	
	
	

}
