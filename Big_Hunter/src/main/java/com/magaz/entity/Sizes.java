package com.magaz.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sizes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String size;

	@OneToMany(mappedBy = "size")
	private Set<Sneaker> sneaker = new HashSet<>();

	public Sizes() {
		super();
	}

	public Sizes(String size) {
		super();
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Set<Sneaker> getSneaker() {
		return sneaker;
	}

	public void setSneaker(Set<Sneaker> sneaker) {
		this.sneaker = sneaker;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Size=" + size + "";
	}

}
