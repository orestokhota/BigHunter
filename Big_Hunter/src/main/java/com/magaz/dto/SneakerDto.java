package com.magaz.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SneakerDto {
	
	private int id;
	private String price;
	private String quantity;
	
	private Set<SModelDto> models = new HashSet<>();
	
	private Set<BrendDto> brends = new HashSet<>();
	
	private Set<TypeDto> types = new HashSet<>();
	
	private Set<SizeDto> sizes = new HashSet<>();

	public SneakerDto() {
		super();
	}

	public SneakerDto(int id, String price, String quantity) {
		super();
		this.id = id;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Set<SModelDto> getModels() {
		return models;
	}

	public void setModels(Set<SModelDto> models) {
		this.models = models;
	}

	public Set<BrendDto> getBrends() {
		return brends;
	}

	public void setBrends(Set<BrendDto> brends) {
		this.brends = brends;
	}

	public Set<TypeDto> getTypes() {
		return types;
	}

	public void setTypes(Set<TypeDto> types) {
		this.types = types;
	}

	public Set<SizeDto> getSizes() {
		return sizes;
	}

	public void setSizes(Set<SizeDto> sizes) {
		this.sizes = sizes;
	}

	
	
	
	
	
}
