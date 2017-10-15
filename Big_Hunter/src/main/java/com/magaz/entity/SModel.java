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
public class SModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String pathImage;

	@ManyToMany
	@JoinTable(name = "sneaker_smodel", joinColumns = @JoinColumn(name = "id_smodel"), inverseJoinColumns = @JoinColumn(name = "id_sneaker"))
	private Set<Sneaker> sneakers = new HashSet<>();
	
//	@ManyToOne
//	private Brend brend;
	
	public SModel() {
		super();
	}

	public SModel(String name) {
		super();
		this.name = name;
	}
	
	

	public SModel(int id, String name, String pathImage) {
		super();
		this.id = id;
		this.name = name;
		this.pathImage = pathImage;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
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

	

//	public Brend getBrend() {
//		return brend;
//	}
//
//	public void setBrend(Brend brend) {
//		this.brend = brend;
//	}
	
	

	public Set<Sneaker> getSneakers() {
		return sneakers;
	}

	public void setSneakers(Set<Sneaker> sneakers) {
		this.sneakers = sneakers;
	}

	@Override
	public String toString() {
		return "SModel [ name=" + name + "]";
	}

	

}
