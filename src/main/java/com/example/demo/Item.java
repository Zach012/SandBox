package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long itemId;
	private String itemName;

//	default constructor
	public Item() {
	}

	public Item(String name) {
		this.itemName = name;
	}

	public Long getId() {

		return itemId;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return itemName;
	}

}
