package com.app.dto;

import java.util.List;

import com.app.model.Item;
import com.app.model.Uom;

public class ItemDTO {
	
	private Item item;
	private List<Uom> uomList;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public List<Uom> getUomList() {
		return uomList;
	}
	public void setUomList(List<Uom> uomList) {
		this.uomList = uomList;
	}
}
