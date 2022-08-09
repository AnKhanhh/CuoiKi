package com.example.cuoiki;

import java.io.Serializable;

public class SerialReceipt implements Serializable {
	String name, type;
	Double price;
	Integer m,l;

	public SerialReceipt(String name, String type, Double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

	String display() {
		return price + " " + name + ", " + type;
	}
}
