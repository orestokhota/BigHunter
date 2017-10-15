package com.magaz.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class SneakerType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	

	
	 @ManyToMany
	 @JoinTable(name = "sneaker_sneaker_type", joinColumns = @JoinColumn(name
	 = "id_sneaker_type"), inverseJoinColumns = @JoinColumn(name =
	 "id_sneaker"))
	 private Set<Sneaker> sneakers = new HashSet<>();



	public SneakerType() {
		super();
	}

	public SneakerType(String name) {
		super();
		this.name = name;
	}
	

	
	
	

	public SneakerType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Sneaker> getSneakers() {
		return sneakers;
	}

	public void setSneakers(Set<Sneaker> sneakers) {
		this.sneakers = sneakers;
	}
	


	@Override
	public String toString() {
		return "SneakerType [" + name + "]";
	}


}
