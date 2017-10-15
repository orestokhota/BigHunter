package com.magaz.editors;

import java.beans.PropertyEditorSupport;

import com.magaz.entity.SModel;

public class ModelEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String idFromJsp) throws IllegalArgumentException {
		
		SModel sModel = new SModel();
		
		sModel.setId(Integer.parseInt(idFromJsp));
		
		setValue(sModel);
		
		
	}

	
	
	
}
