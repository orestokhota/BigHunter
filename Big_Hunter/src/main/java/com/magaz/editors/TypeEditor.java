package com.magaz.editors;

import java.beans.PropertyEditorSupport;

import com.magaz.entity.SneakerType;

public class TypeEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String idFromJsp) throws IllegalArgumentException {

		SneakerType snType = new SneakerType();
		
		
		snType.setId(Integer.parseInt(idFromJsp));
		setValue(snType);
	
	}
	
	

}
