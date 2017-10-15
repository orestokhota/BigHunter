package com.magaz.dto;

public class SModelDto {
	
	private String modelName;
	private String pathImage;
	public SModelDto() {
		super();
	}
	public SModelDto(String modelName, String pathImage) {
		super();
		this.modelName = modelName;
		this.pathImage = pathImage;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	

}
