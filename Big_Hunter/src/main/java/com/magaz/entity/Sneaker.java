package com.magaz.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
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
public class Sneaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String price;
	private  int quantity;

	@OneToMany(mappedBy = "id.sneaker")
	private Set<OrderSneaker> orderSneakers = new HashSet<>();

	@ManyToOne
	private Sizes size;

	

	@ManyToMany
	@JoinTable(name = "sneaker_user", joinColumns = @JoinColumn(name = "id_sneaker"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "sneaker_orders", joinColumns = @JoinColumn(name = "id_sneaker"), inverseJoinColumns = @JoinColumn(name = "id_orders"))
	private List<Orders> orders = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "sneaker_brend", joinColumns = @JoinColumn(name = "id_sneaker"), inverseJoinColumns = @JoinColumn(name = "id_brend"))
	private Set<Brend> brends = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "sneaker_smodel", joinColumns = @JoinColumn(name = "id_sneaker"), inverseJoinColumns = @JoinColumn(name = "id_smodel"))
	private Set<SModel> models = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "sneaker_sneaker_type", joinColumns = @JoinColumn(name = "id_sneaker"), inverseJoinColumns = @JoinColumn(name = "id_sneaker_type"))
	private Set<SneakerType> types = new HashSet<>();

	public Sneaker() {
		super();
	}

	public Sneaker(String price, int quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Sizes getSize() {
		return size;
	}

	public void setSize(Sizes size) {
		this.size = size;
	}

	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Set<Brend> getBrends() {
		return brends;
	}

	public void setBrends(Set<Brend> brends) {
		this.brends = brends;
	}

	public Set<SneakerType> getTypes() {
		return types;
	}

	public void setTypes(Set<SneakerType> types) {
		this.types = types;
	}

	public Set<SModel> getModels() {
		return models;
	}

	public void setModels(Set<SModel> models) {
		this.models = models;
	}

	
	public Set<OrderSneaker> getOrderSneakers() {
		return orderSneakers;
	}

	public void setOrderSneakers(Set<OrderSneaker> orderSneakers) {
		this.orderSneakers = orderSneakers;
	}

	@Override
	public String toString() {
		return "Sneaker [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
