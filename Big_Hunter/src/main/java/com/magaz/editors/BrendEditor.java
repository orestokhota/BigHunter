package com.magaz.editors;

import java.beans.PropertyEditorSupport;

import com.magaz.entity.Brend;

public class BrendEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String idFromJsp) throws IllegalArgumentException {

		Brend brend = new Brend();

		brend.setId(Integer.parseInt(idFromJsp));
		setValue(brend);
	}

}
